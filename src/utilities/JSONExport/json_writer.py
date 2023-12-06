import sys
import os
import json


FIFO_REQUEST = 'json-writer-request'
FIFO_RESPONSE = 'json-writer-response'


class ArgumentError(Exception):
    """Raised if the wrong number of arguments (expect exactly 2) provided."""


class PathError(Exception):
    """Raised if path validation fails. Path must have existing directory and
    non-existing file - this exception will be raised otherwise."""


def write_to_client(message: str) -> None:
    """
    Send specified message to client over FIFO.

    :param message: message to send to client.
    """
    response = open(FIFO_RESPONSE, 'w')
    response.write(message + '\n')
    response.close()


def read_from_client() -> str:
    """
    Receive message from client over FIFO.

    :return: message received from client.
    """
    request = open(FIFO_REQUEST, 'r')
    str_request = request.read()
    request.close()
    return str_request


def write_to_json(str_request: str) -> str:
    """
    Validate the request as a JSON and write it to disk.

    :param str_request: JSON request in string format
    :return: path (relative or absolute - same as call) to file
    :raises: json.JSONDecodeError - unable to read file as JSON.
    """
    json_request = json.loads(str_request)
    directory, file = get_directory_and_file()

    write_file = open(os.path.join(directory, file), 'w')
    json.dump(json_request, write_file)
    write_file.close()

    return os.path.join(directory, file)


def get_directory_and_file() -> tuple[str, str]:
    """
    Validates and returns directory and file based on a path. Validation rules:
    directory must exist (to ensure file is saved in an intended location),
    file must not exist (to ensure no data is deleted).

    :return: (string, string) - (validated directory, validated file).
    :raises: PathError - issue with file validation.
    """
    if len(sys.argv) != 2:
        raise ArgumentError('Usage: json_writer <directory/file>')

    directory, file = os.path.split(sys.argv[1])

    if directory == '':
        raise PathError('Expected directory')
    if not os.path.exists(directory):
        raise PathError(f'Directory "{directory}" does not exist')

    if file == '':
        raise PathError('Expected filename')
    if os.path.exists(os.path.join(directory, file)):
        raise PathError(f'File "{file}" already exists')

    return directory, file


def main():
    str_response = 'ERROR: Unexpected issue writing JSON'

    try:
        str_request = read_from_client()
        str_response = write_to_json(str_request)

    except ArgumentError as e:
        str_response = str(e)

    except PathError as e:
        str_response = 'ERROR: ' + str(e)

    except json.JSONDecodeError as e:
        str_response = 'ERROR: JSON - ' + e.msg

    finally:
        write_to_client(str_response)


if __name__ == '__main__':
    main()

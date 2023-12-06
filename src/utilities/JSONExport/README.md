# CS-361-Portfolio-Microservice

This subprocess allows a local client to write a JSON file to a path.
It verifies that the request contains a valid JSON, validates the path
(directory must exist, file must not exist), writes the file to a JSON,
and reports back with either the location of the saved file or an error
message.

## Request Format

This microservice receives the path to save the JSON at as an argument.
Path must include both a directory and a file name.

Once the microservice has been called as a subprocess, the client opens
a connection over the FIFO 'json-writer-request', writes a JSON to the
FIFO, then closes the FIFO.

## Response Format

After sending a request as described above, the client opens a
connection over the FIFO 'json-writer-response', reads a response from
that FIFO, then closes the FIFO. This response will either be a path to
the location the file was saved or an error message with the prefix
"ERROR: ", if an issue occurred while attempting to fulfil the request. 
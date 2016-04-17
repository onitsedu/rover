Mars Rovers 

OPTIONAL EXTENSION EXERCISE

in order to implement a mechanism to use the solution remotely I implemented an http server that process POST requests in
http://localhost:8080/command that expects on the body of the call a well formed command as explains the exercise

ex.
55
1 2 N 
LMLMLMLMM
3 3 E 
MMRMMRMRRM

to test it I used the postman chrome plugin https://chrome.google.com/webstore/detail/postman/fhbjgbiflinjbdggehcddcbncdddomop
I attach in the reuse folder a collection that can be imported to this plugin with an example of this request.

You can execute the code running The MainRoverServer.java or executing the compiled jar attached.

java -jar OfertiaMarsRover-1.0.jar [portNumber](optional)





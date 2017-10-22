# Exercise 2 - FTP routing

This exercise expands on the file routing exercise

* Check out branch ex2 (`git checkout ex2`)
* Open class `FileToFtpRoute`
* Follow the instructions and make it all work...
* Open class `FtpToFtpRoute`
* Follow the instructions and make it all work...

## Bonus material 

One of the major benefits of this way of routing is that Camel handles the complete monitoring aspect.
This means that you yourself do not have to write code to:
* log in to the ftp site
* monitor if new files have been added
* ignore already processed files
All this is done by just declaring the route

You might try to create (or copy) a file to the starting (from) end-point by "hand" and see what happens.

## Hint(s)

* ftp component
* maven artifact
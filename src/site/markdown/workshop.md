# Workshop

## Introduction

This workshop has a couple of goals:

* Why would or should you want to use Enterprise Integration Patterns (EIP)
* Familiarize yourself with the ease of integration with Camel
* Have some exercise with the framework
* Get the plumbing code to get started for free :-)

## How

This site will walk you through a couple of routes to get familiarize yourself with the Camel framework.
The exercises will be explained below and what is expected. The exercises will start out easy and will progressively get more 
difficult. We will go into the Enterprise Integration Patterns and will also implement some of them.

Hope you like the experience and love the ease with which you can now integrate different technologies and protocols.

## Hump on...

### File routing

One of the things often done in any language is to copy files from one location to another.

In pure java code this will look something like this:

```java
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.InputStream;
import java.io.OutputStream;

/**
* Copy all the files in a folder with specific extension to another folder. 
* Both the folders are specified on the command line. 
* The program currently uses .java extension as filter.
**/
public class CopyFilesWithExtension {
	
	public static void main(String[] args) {
		if(args.length!=2) {
			System.out.println("Command usage: java CopyFilesWithExtension sourcedirectory targetdirectory");
		}
		
		String sourceFolder = args[0];
		String targetFolder = args[1];
		
		File sFile = new File(sourceFolder);
		// Find files with specified extension
		File[] sourceFiles = sFile.listFiles(new FilenameFilter() {
			
			@Override
			public boolean accept(File dir, String name) {
				if(name.endsWith(".java")) {// change this to your extension
					return true;
				}else {
					return false;
				}
			}
		});
		
		// let us copy each file to the target folder
		for(File fSource:sourceFiles) {
			File fTarget = new File(new File(targetFolder), fSource.getName());
			copyFileUsingStream(fSource,fTarget);
			// fSource.delete(); // Uncomment this line if you want source file deleted
		}
		
		
	}
	
	/**
	 * Copies a file using the File streams
	 * @param source
	 * @param dest
	 */
	private static void copyFileUsingStream(File source, File dest)  {
	    InputStream is = null;
	    OutputStream os = null;
	    try {
	        is = new FileInputStream(source);
	        os = new FileOutputStream(dest);
	        byte[] buffer = new byte[1024];
	        int length;
	        while ((length = is.read(buffer)) > 0) {
	            os.write(buffer, 0, length);
	        }
	    }catch(Exception ex) {
	    	System.out.println("Unable to copy file:"+ex.getMessage());
	    }	
	    finally {
	    	try {
	    		is.close();
	    		os.close();
	    	}catch(Exception ex) {}
	    }
	}

}
```

Lets imitate this behavior with a Camel route.

* Please open class ``
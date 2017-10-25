# Exercise 1 - File routing

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
				return name.endsWith(".xml");
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

* Please checkout the exercise 1 branch: `git checkout ex1`
* Please open class `FileCopyRoute`
* Follow the instructions in the code
* Compare the above with what you created...

## Bonus Question(s)

* What do you need to change to make the copy into a move?
* can you move with backup on original location?


## Extra information

In order to get the camel routes to work the following was added to the pom.xml

```xml
<dependencyManagement>
    <dependencies>
        <dependency>
            <groupId>org.apache.camel</groupId>
            <artifactId>camel-parent</artifactId>
            <version>${camel.version}</version>
            <type>pom</type>
            <scope>import</scope>
        </dependency>
    </dependencies>
</dependencyManagement>
```

and

```xml
<dependency>
    <groupId>org.apache.camel</groupId>
    <artifactId>camel-spring-boot-starter</artifactId>
</dependency>
```

## Hint(s)

* Choose
* Simple Expression Language
* File Component 


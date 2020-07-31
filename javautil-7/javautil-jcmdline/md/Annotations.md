<a name="TOCa">

[\@AcceptableValues](#AcceptableValues) | [\@Argument](#Argument) | [\@DependentField](#DependentField) | 
[\@DirectoryExists](#DirectoryExists) [\@DirectoryReadable](#DirectoryReadable) | [\@DirectoryWritable](#DirectoryWritable) | [\@Exclusive](#Exclusive) |
 [\@FileExists](#FileExists) | [\@FileReadable](#FileReadable) | [\@FileWritable](#FileWritable) | [\@Hidden](#Hidden) | [\@MultiValue](#MultiValue) | [\@Optional](#Optional) | [\@Required](#Required) | [\@RequiredUnless](#RequiredUnless) | [\@Requires](#Requires)
</a>

<a name="Parameters">
   
##Parameters  
</a>  

 
* Every parameter must have one of 
     * **[\@Optional](#Optional)**   Options 
     * **[\@Required](#Required)**   Options
     * **[\@Argument](#Argument)**   Arguments
* Files
     * **[\@FileExists](#FileExists)**   File must exist
     * **[\@FileReadable](#FileReadable)** File must exist and be readable
     * **[\@FileWritable](#FileWritable)** does it need to exist
* Directories
     * **[\@DirectoryExists](#DirectoryExists)**
     * **[\@DirectoryReadable](#DirectoryReadable)**
     * **[\@DirectoryWritable](#DirectoryWritable)**
* Inter parameter dependencies
     * **[\@Exclusive](#Exclusive)**
     * **[\@Requires](#Requires)**
* Other
     * **[\@AcceptableValues](#AcceptableValues)**
     * **[\@DependentField](#DependentField)**
     * **[\@Hidden](#Hidden)**


[[toc]](#TOCa)


<a name="AcceptableValues">

## @AcceptableValues 
</a>

Annotation type to indicate a list of values that may be assumed by a String, 

```
@AcceptableValues(values = {"a", "b"}) private String text;
```

[[toc]](#TOCa)

<a name="Argument">

## @Argument
</a>

Annotation type to indicate a parameter should be treated as argument.

```
@Optional
@Argument
@MultiValue(type = ParamType.STRING)
private ArrayList<String> bindPair;
```

[[toc]](#TOCa)

<a name="DependentField">

## @DependentField
</a>

Annotation type to indicate a parameter is required by another parameter. The argument property should be set to a string with the name of the property on the same class that requires it.

example:

The property "schemaName" is required by the property "xsd"
 
code:

```
@Requires("schemaName") String xsd;
```

[[toc]](#TOCa)

<a name="DirectoryExists">

## @DirectoryExists
</a>

Annotation type to indicate a directory must exist.

code:

```
@DirectoryExists private File inputDirectory;
```

[[toc]](#TOCa)

<a name="DirectoryReadable">

## @DirectoryReadable
</a>

Annotation type to indicate a directory must be readable. By definition it must exist.

code:

```
@DirectoryReadable
private File databaseDirectory;
```

[[toc]](#TOCa)

<a name="DirectoryWritable">

## @DirectoryWritable
</a>

Annotation type to indicate a directory must be writable.

code:

```
@DirectoryWriteable
private File databaseDirectory;
```

[[toc]](#TOCa)

<a name="Exclusive">

## @Exclusive 
</a>
  
Annotation type to indicate a parameter is exclusive to another parameter.

The annotation may be on either of the mutually exclusive fields. Having on both fields is not an error, but is redundant.

example:

If parameter 'input' is specified 'workbookLoadId' may not be specified and vice versa.

code:
  
```
@Exclusive(property = "input") Long workbookLoadId = null;
```

[[toc]](#TOCa)

<a name="FileExists">

## @FileExists
</a>

Annotation type to indicate a file must exist.

code:

```
@FileExists
private File outputFile;
```

[[toc]](#TOCa)

<a name="FileReadable">

## @FileReadable
</a>

Annotation type to indicate a file must be readable.

code:

```
@FileReadable
private File definition;
```

[[toc]](#TOCa)

<a name="FileWritable">

## @FileWritable
</a>

Annotation type to indicate a file must be writable

code:

```
@FileWritable
private File definitionOutput;
```

[[toc]](#TOCa)

<a name="Hidden">   
 
## @Hidden

</a>
 
Annotation type to indicate that an argument is hidden; that is, not displayed on help messages.

```
@Optional
@Hidden
private String hiddenParameter;
```

[[toc]](#TOCa)

<a name="MultiValue">
  
## @MultiValue
</a>   
 
Annotation type to indicate a parameter is accepted multiple times. This annotation is mutually exclusive to the FieldValue annotation.
 
 
  example:
  
  The property "downloadUrls" is to be multiple urls to download
 
code:
  
```
 @MultiValue(type=ParamType.STRING) ArrayList<String>  downloadUrls;
```

[[toc]](#TOCa)

<a name="Optional">

## @Optional
</a>

Annotation type to indicate a parameter should be treated as optional. This annotation is mutually exclusive to the Required annotation.

code:

```
@Optional
private String breed;
```

[[toc]](#TOCa)

<a name="Required">

## @Required 
</a>

Annotation type to indicate a parameter should be treated is mandatory. This annotation is mutually exclusive to the Optional annotation.
    
Required options are better self documenting than positional arguments


```
@Required
@AcceptableValues(values = {"a", "b"}) 
private String abba;
```

[[toc]](#TOCa)

<a name="RequiredUnless">
  
## @RequiredUnless
</a>
 
Annotation type to indicate a parameter should be treated as required unless another parameter is specified.

```
@RequiredUnless(property = "toad")
private String frog;

@Optional
private String toad;
```

[[toc]](#TOCa)

<a name="Requires">

## @Requires

</a>
 
Annotation type to indicate a parameter is required by another parameter. The argument property should be set to a string with the name of the property on the same class that requires it.
  
 example:
  
 The property "schemaName" is required by the property "xsd"'

```
@Requires("schemaName") String xsd;
```

[[toc]](#TOCa)
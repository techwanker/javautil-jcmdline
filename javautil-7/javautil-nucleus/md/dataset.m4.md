changequote(`{{', `}}')

# Dataset

A dataset is analogous to a database table.

A dataset is composed of [data]  and [metadata] and has a simple interface

```
include({{Dataset.java}})
```

## Data

The data is composed of rows of columns.  Internal represenations may vary, common are 
List<List<Object>> and List<Map<String,Object> 

Datasets can be created a large number of ways:

* from json TODO
* from XML TODO
* from sqlQueries TODO 
* from csv pairs (data and metadata) TODO
* procedurally TODO 

They may then be manipulated, map/reduced and rendered

* crosstabbed TODO
* filtered TODO
* sorted TODO
* extracted to a database table (even a temporary in memory table) TODO

Rendering/marshalling

* to json TODO
* to xml TODO
* expose as a java object to a markup language TODO
* to csv pairs TODO
* excel region TODO




## Metadata 

Metadata describes the information contained in Data.

This includes information about 

* java Object Type
* Database column type
* Rendering information
* and more

Rendering information includes positioning and formatting.

TODO this should embed the javadoc !!!
``
include({{./DatasetMetadata.java}}) 
```

The DataSet DatasetMetaData ColumnData

```
include({{./ColumnMetadata.java}})
```


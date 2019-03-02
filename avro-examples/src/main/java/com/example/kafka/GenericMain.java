package com.example.kafka;

import java.io.File;
import java.io.InputStream;
import java.io.IOException;

import org.apache.avro.Schema;
import org.apache.avro.Schema.Parser;
import org.apache.avro.file.DataFileReader;
import org.apache.avro.file.DataFileWriter;
import org.apache.avro.generic.GenericData;
import org.apache.avro.generic.GenericDatumReader;
import org.apache.avro.generic.GenericDatumWriter;
import org.apache.avro.generic.GenericRecord;
import org.apache.avro.io.DatumReader;
import org.apache.avro.io.DatumWriter;

public class GenericMain {
  public static void main(String[] args) throws IOException {
    Schema schema = loadSchema("Payment2.avsc");

    GenericRecord p1 = new GenericData.Record(schema);
    p1.put("id", "ABC");
    p1.put("amount", 900D);
    p1.put("region", "Tokyo");

    GenericRecord p2 = new GenericData.Record(schema);
    p2.put("id", "DEF");
    p2.put("amount", 200D);

    GenericRecord p3 = new GenericData.Record(schema);
    p3.put("id", "GHI");
    p3.put("amount", 300D);
    p3.put("region", "NOWHERE");

    // Serialize to disk
    File file = new File("payment.avro");
    DatumWriter<GenericRecord> datumWriter = new GenericDatumWriter<GenericRecord>();
    DataFileWriter<GenericRecord> dataFileWriter = new DataFileWriter<GenericRecord>(datumWriter);
    // If you want to open a writer appending to an existing file,
    // dataFileWriter.appendTo(file);
    dataFileWriter.create(schema, file);
    dataFileWriter.append(p1);
    dataFileWriter.append(p2);
    dataFileWriter.append(p3);
    dataFileWriter.close();

    // Deserialize from disk

    // You don't need specify schema if you want to deserialize using the same schema as serialized one.
    DatumReader<GenericRecord> datumReader = new GenericDatumReader<GenericRecord>(schema);
    // DatumReader<GenericRecord> datumReader = new GenericDatumReader<GenericRecord>();
    DataFileReader<GenericRecord> dataFileReader = new DataFileReader<GenericRecord>(file, datumReader);
    GenericRecord p = null;
    while (dataFileReader.hasNext()) {
      // Reuse p object by passing it to next(). This saves us from
      // allocating and garbage collecting many objects for files with
      // many items.
      p = dataFileReader.next(p);
      System.out.println(p);
    }

  }

  private static Schema loadSchema(final String name) throws IOException {
    try (
      final InputStream input =
        GenericMain
          .class
          .getClassLoader()
          .getResourceAsStream("avro/com/example/kafka/" + name)
    ) {
      return new Schema.Parser().parse(input);
    }
  }
}

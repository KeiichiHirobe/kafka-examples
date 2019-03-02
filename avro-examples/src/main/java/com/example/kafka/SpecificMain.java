package com.example.kafka;

import java.io.File;
import java.io.IOException;

import org.apache.avro.file.DataFileReader;
import org.apache.avro.file.DataFileWriter;
import org.apache.avro.io.DatumReader;
import org.apache.avro.io.DatumWriter;
import org.apache.avro.specific.SpecificDatumReader;
import org.apache.avro.specific.SpecificDatumWriter;

public class SpecificMain {
  public static void main(String[] args) throws IOException {
    Payment2 p1 = new Payment2();
    p1.setId("ABC");
    p1.setAmount(900D);
    p1.setRegion("Tokyo");

    // Alternate constructor
    Payment2 p2 = new Payment2("DEF", 200D, null);

    // Construct via builder
    // Unlike constructors, builders will automatically set any default values specified in the schema
    // Here, setRegion("NOWHERE") implicitly.
    Payment2 p3 = Payment2.newBuilder()
             .setId("GHI")
             .setAmount(300D)
             .build();

   /**
    * Comment out because codes below are for case of Payment1
    *
    * Payment1 p1 = new Payment1();
    * p1.setId("ABC");
    * p1.setAmount(900D);
    * // Alternate constructor
    * Payment1 p2 = new Payment1("DEF", 200D);
    * // Construct via builder
    * Payment1 p3 = Payment1.newBuilder()
    *        .setId("GHI")
    *        .setAmount(300D)
    *        .build();
    */

    // Serialize to disk
    File file = new File("payment.avro");
    DatumWriter<Payment2> paymentDatumWriter = new SpecificDatumWriter<Payment2>(Payment2.class);
    DataFileWriter<Payment2> dataFileWriter = new DataFileWriter<Payment2>(paymentDatumWriter);
    // If you want to open a writer appending to an existing file,
    // dataFileWriter.appendTo(file);
    dataFileWriter.create(p1.getSchema(), file);
    dataFileWriter.append(p1);
    dataFileWriter.append(p2);
    dataFileWriter.append(p3);
    dataFileWriter.close();

    // Deserialize from disk
    DatumReader<Payment2> paymentDatumReader = new SpecificDatumReader<Payment2>(Payment2.class);
    DataFileReader<Payment2> dataFileReader = new DataFileReader<Payment2>(file, paymentDatumReader);
    Payment2 p = null;
    while (dataFileReader.hasNext()) {
      // Reuse p object by passing it to next(). This saves us from
      // allocating and garbage collecting many objects for files with
      // many items.
      p = dataFileReader.next(p);
      System.out.println(p);
    }

  }
}

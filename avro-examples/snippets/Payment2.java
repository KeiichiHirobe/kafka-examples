/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package com.example.kafka;

import org.apache.avro.specific.SpecificData;
import org.apache.avro.message.BinaryMessageEncoder;
import org.apache.avro.message.BinaryMessageDecoder;
import org.apache.avro.message.SchemaStore;

@SuppressWarnings("all")
@org.apache.avro.specific.AvroGenerated
public class Payment2 extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = 1847419088487348622L;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"Payment2\",\"namespace\":\"com.example.kafka\",\"fields\":[{\"name\":\"id\",\"type\":\"string\"},{\"name\":\"amount\",\"type\":\"double\"},{\"name\":\"region\",\"type\":[\"string\",\"null\"],\"default\":\"NOWHERE\"}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static SpecificData MODEL$ = new SpecificData();

  private static final BinaryMessageEncoder<Payment2> ENCODER =
      new BinaryMessageEncoder<Payment2>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<Payment2> DECODER =
      new BinaryMessageDecoder<Payment2>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   */
  public static BinaryMessageDecoder<Payment2> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   */
  public static BinaryMessageDecoder<Payment2> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<Payment2>(MODEL$, SCHEMA$, resolver);
  }

  /** Serializes this Payment2 to a ByteBuffer. */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /** Deserializes a Payment2 from a ByteBuffer. */
  public static Payment2 fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

  @Deprecated public java.lang.CharSequence id;
  @Deprecated public double amount;
  @Deprecated public java.lang.CharSequence region;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public Payment2() {}

  /**
   * All-args constructor.
   * @param id The new value for id
   * @param amount The new value for amount
   * @param region The new value for region
   */
  public Payment2(java.lang.CharSequence id, java.lang.Double amount, java.lang.CharSequence region) {
    this.id = id;
    this.amount = amount;
    this.region = region;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return id;
    case 1: return amount;
    case 2: return region;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: id = (java.lang.CharSequence)value$; break;
    case 1: amount = (java.lang.Double)value$; break;
    case 2: region = (java.lang.CharSequence)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'id' field.
   * @return The value of the 'id' field.
   */
  public java.lang.CharSequence getId() {
    return id;
  }

  /**
   * Sets the value of the 'id' field.
   * @param value the value to set.
   */
  public void setId(java.lang.CharSequence value) {
    this.id = value;
  }

  /**
   * Gets the value of the 'amount' field.
   * @return The value of the 'amount' field.
   */
  public java.lang.Double getAmount() {
    return amount;
  }

  /**
   * Sets the value of the 'amount' field.
   * @param value the value to set.
   */
  public void setAmount(java.lang.Double value) {
    this.amount = value;
  }

  /**
   * Gets the value of the 'region' field.
   * @return The value of the 'region' field.
   */
  public java.lang.CharSequence getRegion() {
    return region;
  }

  /**
   * Sets the value of the 'region' field.
   * @param value the value to set.
   */
  public void setRegion(java.lang.CharSequence value) {
    this.region = value;
  }

  /**
   * Creates a new Payment2 RecordBuilder.
   * @return A new Payment2 RecordBuilder
   */
  public static com.example.kafka.Payment2.Builder newBuilder() {
    return new com.example.kafka.Payment2.Builder();
  }

  /**
   * Creates a new Payment2 RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new Payment2 RecordBuilder
   */
  public static com.example.kafka.Payment2.Builder newBuilder(com.example.kafka.Payment2.Builder other) {
    return new com.example.kafka.Payment2.Builder(other);
  }

  /**
   * Creates a new Payment2 RecordBuilder by copying an existing Payment2 instance.
   * @param other The existing instance to copy.
   * @return A new Payment2 RecordBuilder
   */
  public static com.example.kafka.Payment2.Builder newBuilder(com.example.kafka.Payment2 other) {
    return new com.example.kafka.Payment2.Builder(other);
  }

  /**
   * RecordBuilder for Payment2 instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<Payment2>
    implements org.apache.avro.data.RecordBuilder<Payment2> {

    private java.lang.CharSequence id;
    private double amount;
    private java.lang.CharSequence region;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(com.example.kafka.Payment2.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.id)) {
        this.id = data().deepCopy(fields()[0].schema(), other.id);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.amount)) {
        this.amount = data().deepCopy(fields()[1].schema(), other.amount);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.region)) {
        this.region = data().deepCopy(fields()[2].schema(), other.region);
        fieldSetFlags()[2] = true;
      }
    }

    /**
     * Creates a Builder by copying an existing Payment2 instance
     * @param other The existing instance to copy.
     */
    private Builder(com.example.kafka.Payment2 other) {
            super(SCHEMA$);
      if (isValidValue(fields()[0], other.id)) {
        this.id = data().deepCopy(fields()[0].schema(), other.id);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.amount)) {
        this.amount = data().deepCopy(fields()[1].schema(), other.amount);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.region)) {
        this.region = data().deepCopy(fields()[2].schema(), other.region);
        fieldSetFlags()[2] = true;
      }
    }

    /**
      * Gets the value of the 'id' field.
      * @return The value.
      */
    public java.lang.CharSequence getId() {
      return id;
    }

    /**
      * Sets the value of the 'id' field.
      * @param value The value of 'id'.
      * @return This builder.
      */
    public com.example.kafka.Payment2.Builder setId(java.lang.CharSequence value) {
      validate(fields()[0], value);
      this.id = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'id' field has been set.
      * @return True if the 'id' field has been set, false otherwise.
      */
    public boolean hasId() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'id' field.
      * @return This builder.
      */
    public com.example.kafka.Payment2.Builder clearId() {
      id = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'amount' field.
      * @return The value.
      */
    public java.lang.Double getAmount() {
      return amount;
    }

    /**
      * Sets the value of the 'amount' field.
      * @param value The value of 'amount'.
      * @return This builder.
      */
    public com.example.kafka.Payment2.Builder setAmount(double value) {
      validate(fields()[1], value);
      this.amount = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'amount' field has been set.
      * @return True if the 'amount' field has been set, false otherwise.
      */
    public boolean hasAmount() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'amount' field.
      * @return This builder.
      */
    public com.example.kafka.Payment2.Builder clearAmount() {
      fieldSetFlags()[1] = false;
      return this;
    }

    /**
      * Gets the value of the 'region' field.
      * @return The value.
      */
    public java.lang.CharSequence getRegion() {
      return region;
    }

    /**
      * Sets the value of the 'region' field.
      * @param value The value of 'region'.
      * @return This builder.
      */
    public com.example.kafka.Payment2.Builder setRegion(java.lang.CharSequence value) {
      validate(fields()[2], value);
      this.region = value;
      fieldSetFlags()[2] = true;
      return this;
    }

    /**
      * Checks whether the 'region' field has been set.
      * @return True if the 'region' field has been set, false otherwise.
      */
    public boolean hasRegion() {
      return fieldSetFlags()[2];
    }


    /**
      * Clears the value of the 'region' field.
      * @return This builder.
      */
    public com.example.kafka.Payment2.Builder clearRegion() {
      region = null;
      fieldSetFlags()[2] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Payment2 build() {
      try {
        Payment2 record = new Payment2();
        record.id = fieldSetFlags()[0] ? this.id : (java.lang.CharSequence) defaultValue(fields()[0]);
        record.amount = fieldSetFlags()[1] ? this.amount : (java.lang.Double) defaultValue(fields()[1]);
        record.region = fieldSetFlags()[2] ? this.region : (java.lang.CharSequence) defaultValue(fields()[2]);
        return record;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<Payment2>
    WRITER$ = (org.apache.avro.io.DatumWriter<Payment2>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<Payment2>
    READER$ = (org.apache.avro.io.DatumReader<Payment2>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

}

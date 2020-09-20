package com.thoughtworks.basic;

import ConsoleCommandAnalysis.FlagSchema;
import ConsoleCommandAnalysis.Schema;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class SchemaTest {
    @Test
    public void should_return_boolean_when_get_type_given_flag(){
        Set<FlagSchema> flagSchemas = new HashSet<>();
        flagSchemas.add(new FlagSchema("l",Boolean.TYPE));
        flagSchemas.add(new FlagSchema("d",String.class));
        flagSchemas.add(new FlagSchema("p",Integer.class));
        Schema schema = new Schema(flagSchemas);
        Object type_l = schema.getTypeOf("l");
        Object type_d = schema.getTypeOf("d");
        Object type_p = schema.getTypeOf("p");
        Assert.assertEquals(Boolean.TYPE, type_l);
        Assert.assertEquals(String.class, type_d);
        Assert.assertEquals(Integer.class, type_p);
    }
}

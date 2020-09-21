package com.thoughtworks.basic;

import ConsoleCommandAnalysis.Args;
import ConsoleCommandAnalysis.Arg;
import ConsoleCommandAnalysis.FlagSchema;
import ConsoleCommandAnalysis.Schema;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ArgsTest {
    @Test
    public void should_return_size_3_when_new_Args_given_string_and_schema() throws Exception {
        //given
        String argsText = "-l true -p 8080 -d usr/logs";
        Set<FlagSchema> flagSchemas = new HashSet<>();
        flagSchemas.add(new FlagSchema("l", Boolean.TYPE));
        flagSchemas.add(new FlagSchema("d", String.class));
        flagSchemas.add(new FlagSchema("p", Integer.class));
        Schema schema = new Schema(flagSchemas);

        //when
        Args args = new Args(argsText, schema);

        //then
        Assert.assertEquals(3, args.getArgSet().size());
    }

    @Test
    public void should_return_true_when_new_Args_given_string_and_schema() throws Exception {
        //given
        String argsText = "-l true -p 8080 -d usr/logs";
        Set<FlagSchema> flagSchemas = new HashSet<>();
        flagSchemas.add(new FlagSchema("l", Boolean.TYPE));
        flagSchemas.add(new FlagSchema("d", String.class));
        flagSchemas.add(new FlagSchema("p", Integer.class));
        Schema schema = new Schema(flagSchemas);
        Args args = new Args(argsText, schema);

        //when
        String l = args.getValueOf("l");

        //then
        Assert.assertEquals("true", l);
    }

    @Test
    public void should_return_8080_when_new_Args_given_string_and_schema() throws Exception {
        //given
        String argsText = "-l true -p 8080 -d usr/logs";
        Set<FlagSchema> flagSchemas = new HashSet<>();
        flagSchemas.add(new FlagSchema("l", Boolean.TYPE));
        flagSchemas.add(new FlagSchema("d", String.class));
        flagSchemas.add(new FlagSchema("p", Integer.class));
        Schema schema = new Schema(flagSchemas);
        Args args = new Args(argsText, schema);

        //when
        String p = args.getValueOf("p");

        //then
        Assert.assertEquals("8080", p);
    }

    @Test
    public void should_return_usr_logs_when_new_Args_given_string_and_schema() throws Exception {
        //given
        String argsText = "-l true -p 8080 -d usr/logs";
        Set<FlagSchema> flagSchemas = new HashSet<>();
        flagSchemas.add(new FlagSchema("l", Boolean.TYPE));
        flagSchemas.add(new FlagSchema("d", String.class));
        flagSchemas.add(new FlagSchema("p", Integer.class));
        Schema schema = new Schema(flagSchemas);
        Args args = new Args(argsText, schema);

        //when
        String d = args.getValueOf("d");

        //then
        Assert.assertEquals("usr/logs", d);
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_return_IllegalArgumentException_when_new_Args_given_string_and_schema() throws Exception {
        //given
        String argsText = "-l true -p 8080 -d usr/logs";
        Set<FlagSchema> flagSchemas = new HashSet<>();
        flagSchemas.add(new FlagSchema("l", Boolean.TYPE));
        flagSchemas.add(new FlagSchema("d", String.class));
        flagSchemas.add(new FlagSchema("p", Integer.class));
        Schema schema = new Schema(flagSchemas);
        Args args = new Args(argsText, schema);

        //when
        String a = args.getValueOf("a");
    }

    @Test
    public void should_return_a_is_not_defined_when_new_Args_given_string_and_schema() {
        //given
        String argsText = "-l true -p 8080 -d usr/logs";
        Set<FlagSchema> flagSchemas = new HashSet<>();
        flagSchemas.add(new FlagSchema("l", Boolean.TYPE));
        flagSchemas.add(new FlagSchema("d", String.class));
        flagSchemas.add(new FlagSchema("p", Integer.class));
        Schema schema = new Schema(flagSchemas);
        Args args = new Args(argsText, schema);

        //when
        String errorStr = "";
        try {
            String a = args.getValueOf("a");
        } catch (Exception e) {
            errorStr = e.getMessage();
        }

        //then
        Assert.assertEquals("a is not find!", errorStr);
    }

    @Test
    public void should_return_default_value_when_new_Args_given_string_and_schema() throws Exception {
        //given
        String argsText = "-l true";
        Set<FlagSchema> flagSchemas = new HashSet<>();
        flagSchemas.add(new FlagSchema("l", Boolean.TYPE));
        flagSchemas.add(new FlagSchema("d", String.class));
        flagSchemas.add(new FlagSchema("p", Integer.class));
        Schema schema = new Schema(flagSchemas);
        Args args = new Args(argsText, schema);

        //when
        String l = args.getValueOf("l");
        String p = args.getValueOf("p");
        String d = args.getValueOf("d");


        //then
        Assert.assertEquals("true", l);
        Assert.assertEquals("0", p);
        Assert.assertEquals("", d);
    }

    @Test
    public void should_return_false_when_new_Args_given_string_and_schema() throws Exception {
        //given
        String argsText = "-p 8080";
        Set<FlagSchema> flagSchemas = new HashSet<>();
        flagSchemas.add(new FlagSchema("l", Boolean.TYPE));
        flagSchemas.add(new FlagSchema("d", String.class));
        flagSchemas.add(new FlagSchema("p", Integer.class));
        Schema schema = new Schema(flagSchemas);
        Args args = new Args(argsText, schema);

        //when
        String l = args.getValueOf("l");

        //then
        Assert.assertEquals("false", l);
    }
}

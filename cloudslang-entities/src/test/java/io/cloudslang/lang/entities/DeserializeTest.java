package io.cloudslang.lang.entities;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.cloudslang.lang.entities.bindings.Argument;
import io.cloudslang.lang.entities.bindings.Input;
import io.cloudslang.lang.entities.bindings.Output;
import io.cloudslang.lang.entities.bindings.Result;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class DeserializeTest {

    private ObjectMapper mapper;

    @Before
    public void setUp() throws Exception {
        mapper = new ObjectMapper().enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
    }

    private <T> void testToAndFromJson(Object objToTest, Class<T> type) throws IOException {
        //jackson
        String objAsString = mapper.writeValueAsString(objToTest);
        T objAfterDeserialize = mapper.readValue(objAsString, type);
        assertEquals(objToTest, objAfterDeserialize);
    }

    @Test
    public void testDeserializeInput() throws IOException {
        Input input = new Input(
                "new_input",
                "some_expression",
                true,
                true,
                true,
                "system_property_ok_a_kind");
        testToAndFromJson(input, Input.class);
    }

    @Test
    public void testDeserializeArgument() throws IOException {
        Argument argument = new Argument(
                "new_argument",
                "some_expression"
        );
        testToAndFromJson(argument, Argument.class);
    }

    @Test
    public void testDeserializeOutput() throws IOException {
        Output output = new Output(
                "new_output",
                "some_expression");
        testToAndFromJson(output, Output.class);
    }

    @Test
    public void testDeserializeResult() throws IOException {
        Result result = new Result(
                "new_result",
                "some_expression");
        testToAndFromJson(result, Result.class);
    }

    @Test
    public void testDeserializeResultNavigation() throws IOException {
        ResultNavigation resultNavigation = new ResultNavigation(
                1L,
                "a preset result");
        testToAndFromJson(resultNavigation, ResultNavigation.class);
    }

    @Test
    public void testDeserializeListForLoopStatement() throws IOException {
        LoopStatement listForLoopStatement = new ListForLoopStatement("varName", "expression");
        testToAndFromJson(listForLoopStatement, ListForLoopStatement.class);
    }

    @Test
    public void testDeserializeMapForLoopStatement() throws IOException {
        MapForLoopStatement mapForLoopStatement = new MapForLoopStatement("keyName", "valueName", "expression");
        testToAndFromJson(mapForLoopStatement, MapForLoopStatement.class);
    }

    @Test
    public void testDeserializeAsyncLoopStatement() throws IOException {
        AsyncLoopStatement asyncLoopStatement = new AsyncLoopStatement("varName", "expression");
        testToAndFromJson(asyncLoopStatement, AsyncLoopStatement.class);
    }

}

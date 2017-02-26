package com.example;

import au.com.dius.pact.provider.PactVerifyProvider;
import au.com.dius.pact.provider.junit.Consumer;
import au.com.dius.pact.provider.junit.PactRunner;
import au.com.dius.pact.provider.junit.Provider;
import au.com.dius.pact.provider.junit.loader.PactFolder;
import au.com.dius.pact.provider.junit.target.AmqpTarget;
import au.com.dius.pact.provider.junit.target.Target;
import au.com.dius.pact.provider.junit.target.TestTarget;
import org.junit.runner.RunWith;

@RunWith(PactRunner.class) // Say JUnit to run tests with custom Runner
@Provider("provider") // Set up name of tested provider'
@Consumer("consumer")
@PactFolder("src/main/resources/pacts")
public class ProviderMessageTest {

    @TestTarget // Annotation denotes Target that will be used for tests
    public final Target target = new AmqpTarget(); // Out-of-the-box implementation of Target (for more information take a look at Test Target section)

    @PactVerifyProvider("a test message")
    public String verifyMessageForOrder() {


        return "{\"stringThing\": \"a string\", \"integerThing\": 5}";
    }


}

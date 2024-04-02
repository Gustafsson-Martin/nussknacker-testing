package se.brocc.nussknacker.components;

import java.util.concurrent.CompletableFuture;

import pl.touk.nussknacker.engine.api.MethodToInvoke;
import pl.touk.nussknacker.engine.api.ParamName;
import pl.touk.nussknacker.engine.api.Service;


public class ExampleComponent extends Service {
    @MethodToInvoke
    public CompletableFuture<Integer> invoke(@ParamName("length") int argument) {
        return CompletableFuture.completedFuture(argument*10);
    }
}
package se.brocc.nussknacker.components;

import com.typesafe.config.Config;

import pl.touk.nussknacker.engine.api.component.ComponentProvider;
import pl.touk.nussknacker.engine.api.component.NussknackerVersion;
import pl.touk.nussknacker.engine.api.component.ComponentDefinition;
import pl.touk.nussknacker.engine.api.process.ProcessObjectDependencies;

import java.util.ArrayList;
import scala.collection.JavaConverters;
import scala.collection.immutable.List;
import scala.Option;

public class ExampleComponentProvider implements ComponentProvider {

    @Override
    public String providerName() {
        return "example";
    }

    @Override
    public Config resolveConfigForExecution(Config config) {
        return config;
    }

    @Override
    public List<ComponentDefinition> create(Config config, ProcessObjectDependencies dependencies) {
        ArrayList<ComponentDefinition> componentDefinitions = new ArrayList<>();

        componentDefinitions.add(new ComponentDefinition("multiplyInputByTen", new ExampleComponent(), Option.empty(), Option.empty()));
        componentDefinitions.add(new ComponentDefinition("multiplyInputByTenAgain", new ExampleComponent(), Option.empty(), Option.empty()));

        return JavaConverters.asScalaBuffer(componentDefinitions).toList();
    }

    @Override
    public boolean isCompatible(NussknackerVersion version) {
        return true;
    }

    @Override
    public boolean isAutoLoaded() {
        return true;
    }
}

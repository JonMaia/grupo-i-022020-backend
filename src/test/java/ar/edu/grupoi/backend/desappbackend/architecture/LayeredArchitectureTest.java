package ar.edu.grupoi.backend.desappbackend.architecture;

import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;

import static com.tngtech.archunit.library.Architectures.layeredArchitecture;

@AnalyzeClasses(packages = "ar.edu.grupoi.backend.desappbackend")
public class LayeredArchitectureTest {

	@ArchTest
	static final ArchRule layer_dependencies_are_respected = layeredArchitecture()

			.layer("Controllers").definedBy("ar.edu.grupoi.backend.desappbackend.webservice..")
			.layer("Services").definedBy("ar.edu.grupoi.backend.desappbackend.service..")
			.layer("Repository").definedBy("ar.edu.grupoi.backend.desappbackend.repositories..")

			.whereLayer("Controllers").mayNotBeAccessedByAnyLayer()
			.whereLayer("Services").mayOnlyBeAccessedByLayers("Controllers")
			.whereLayer("Repository").mayOnlyBeAccessedByLayers("Services");
}

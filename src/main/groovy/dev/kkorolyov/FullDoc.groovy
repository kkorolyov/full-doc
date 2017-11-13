package dev.kkorolyov

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.tasks.javadoc.Javadoc

class FullDoc implements Plugin<Project> {
	@Override
	void apply(Project project) {
		def fulldoc = project.extensions.create('fulldoc', FullDocExtension)

		project.task(
				group: 'documentation',
				description: "Bundles documentation output of subprojects into a single deployable package.",
				'fulldoc'
		) {
			def docTasks = project.subprojects.collect {it.tasks.withType(Javadoc)}
			dependsOn docTasks

			doLast {
				docTasks.each {
					def docTask = it.head()
					def projectName = docTask.getProject().name

					project.copy {
						from docTask
						into "$fulldoc.out/$projectName"
					}
					println "Copied $projectName project's docs"
				}
				project.copy {
					from fulldoc.src
					into fulldoc.out
				}
				println "Copied main docs src"
			}
		}
	}
}

class FullDocExtension {
	/** Source directory of root project documentation */
	String src
	/** Output directory of bundled documentation */
	String out
}

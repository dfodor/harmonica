/*
 * Harmonica: Kotlin Database Migration Tool
 * Copyright (C) 2019  Kenji Otsuka
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

package com.improve_future.harmonica.plugin

import com.improve_future.harmonica.config.PluginConfig
import org.gradle.api.Plugin
import org.gradle.api.Project

open class HarmonicaPlugin: Plugin<Project> {
    override fun apply(project: Project) {
        project.tasks.run {
            create("harmonicaUp", MigrationUpTask::class.java) {
                it.group = PluginConfig.groupName
                it.description = "Migrate up."
            }

            create("harmonicaCreate", MigrationCreate::class.java) {
                it.group = PluginConfig.groupName
                it.description = "Migrate down."
            }

            create("harmonicaDown", MigrationDownTask::class.java) {
                it.group = PluginConfig.groupName
                it.description = "Create migration file."
            }
        }
    }
}
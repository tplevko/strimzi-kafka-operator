/*
 * Copyright 2018, Strimzi authors.
 * License: Apache License 2.0 (see the file LICENSE or http://apache.org/licenses/LICENSE-2.0.html).
 */
package io.strimzi.api.kafka.model;

import io.strimzi.crdgenerator.annotations.Description;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.sundr.builder.annotations.Buildable;
import io.vertx.core.cli.annotations.DefaultValue;

/**
 * A representation of a topic resource for ACLs
 */
@Buildable(
        editableEnabled = false,
        generateBuilderPackage = true,
        builderPackage = "io.strimzi.api.kafka.model"
)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AclRuleTopicResource extends AclRuleResource {
    private static final long serialVersionUID = 1L;

    public static final String TYPE_TOPIC = "topic";

    private String name;
    private AclResourcePatternType patternType;

    @Description("Must be `" + TYPE_TOPIC + "`")
    @Override
    public String getType() {
        return TYPE_TOPIC;
    }

    @Description("Describes the pattern used in the resource field. " +
            "The supported types are `literal` and `prefix`. " +
            "With `literal` pattern type, the resource field will be used as a definition of a full topic name. " +
            "With `prefix` pattern type, the resource name will be used only as a prefix. " +
            "Default value is `literal`.")
    @DefaultValue("literal")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public AclResourcePatternType getPatternType() {
        return patternType;
    }

    public void setPatternType(AclResourcePatternType patternType) {
        this.patternType = patternType;
    }

    @Description("Name of resource for which given ACL rule applies. " +
            "Can be combined with `patternType` field to use prefix pattern.")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
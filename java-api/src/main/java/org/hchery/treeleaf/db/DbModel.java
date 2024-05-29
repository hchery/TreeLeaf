package org.hchery.treeleaf.db;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.io.Serial;
import java.io.Serializable;

/**
 * DATE: 2024/5/14
 * AUTHOR: hchery
 * URL: https://github.com/hchery
 * EMAIL: h.chery@qq.com
 */
@Data
public abstract class DbModel implements Serializable {
    @Serial
    private static final long serialVersionUID = 6608054965831541L;

    @MongoId(targetType = FieldType.OBJECT_ID)
    private String id;
}

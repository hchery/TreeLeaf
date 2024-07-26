package org.hchery.treeleaf.db.key;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.hchery.treeleaf.db.MutableDbModel;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serial;

/**
 * DATE: 2024/5/29
 * AUTHOR: hchery
 * URL: https://github.com/hchery
 * EMAIL: h.chery@qq.com
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ToString(callSuper = true)
public abstract class KeyDbModel extends MutableDbModel {
    @Serial
    private static final long serialVersionUID = -3301791337870195266L;

    @Field("name")
    private String name;

    @Field("show_name")
    private String showName;

    @Field("desc")
    private String desc;
}

package org.hchery.treeleaf.db.user;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.hchery.treeleaf.db.MutableDbModel;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serial;

/**
 * DATE: 2024/5/14
 * AUTHOR: hchery
 * URL: https://github.com/hchery
 * EMAIL: h.chery@qq.com
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ToString(callSuper = true)
@Document("user_details")
public class User extends MutableDbModel {
    @Serial
    private static final long serialVersionUID = -4671206584927585347L;

    @Indexed(unique = true)
    @Field("email")
    private String email;

    @Indexed
    @Field("nickname")
    private String nickname;

    @Field("password")
    private String password;

    @Indexed
    @Field("phone")
    private String phone;
}

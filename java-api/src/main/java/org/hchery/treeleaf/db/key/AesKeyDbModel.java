package org.hchery.treeleaf.db.key;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;
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
@Document("keys_aes")
public class AesKeyDbModel extends KeyDbModel {
    @Serial
    private static final long serialVersionUID = 6377124332915353282L;

    @Field("key")
    private byte[] key;
}

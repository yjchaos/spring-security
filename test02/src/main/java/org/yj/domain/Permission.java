package org.yj.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author yaojun
 */
@ToString
public class Permission {

    // ~ Instance fields
    // ================================================================================================

    @Getter
    @Setter
    private Long id;

    @Getter
    @Setter
    private String permName;

    @Getter
    @Setter
    private String permTag;
    // ~ Constructors
    // ===================================================================================================

    // ~ Methods
    // ========================================================================================================


}

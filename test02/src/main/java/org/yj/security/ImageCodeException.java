package org.yj.security;

import org.springframework.security.core.AuthenticationException;

/**
 * @author yaojun
 */
public class ImageCodeException extends AuthenticationException {

    // ~ Static fields/initializers
    // =====================================================================================

    // ~ Instance fields
    // ================================================================================================

    // ~ Constructors
    // ===================================================================================================

    public ImageCodeException(String msg, Throwable t) {
        super(msg, t);
    }

    public ImageCodeException(String msg) {
        super(msg);
    }

    // ~ Methods
    // ========================================================================================================


}

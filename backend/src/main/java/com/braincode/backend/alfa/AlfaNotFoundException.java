package com.braincode.backend.alfa;

class AlfaNotFoundException extends RuntimeException {
    AlfaNotFoundException(Long id) {
        super("Could not find alfa " + id);
    }
}

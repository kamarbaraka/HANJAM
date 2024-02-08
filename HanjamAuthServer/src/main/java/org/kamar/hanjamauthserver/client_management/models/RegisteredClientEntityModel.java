package org.kamar.hanjamauthserver.client_management.models;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;

/**
 * Represents a registered client entity model.
 * Extends RepresentationModel from Spring HATEOAS.
 *
 * @author <a href="https://github.com/kamarbaraka">samson baraka</a>.
 */

@Getter
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class RegisteredClientEntityModel extends RepresentationModel<RegisteredClientEntityModel> {

    /**
     * The name of the client.
     */
    private String clientName;

    /**
     * The client ID assigned to a registered client entity.
     * This ID uniquely identifies the client within the system.
     */
    private String clientId;

    /**
     * The client secret associated with a registered client.
     * This secret is used for authenticating the client during authorization requests.
     * It should be kept confidential and not shared with unauthorized parties.
     */
    private String clientSecret;
}

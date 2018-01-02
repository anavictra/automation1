package utility;

import com.displaynote.xmpp.client.commands.msg.register.AddDeviceRequestPayload;
import com.displaynote.xmpp.client.commands.msg.register.AddDeviceRequestResultPayload;
import com.displaynote.xmpp.client.commands.msg.support.ReceiverPlatform;
import com.displaynote.xmpp.client.exceptions.XmppClientException;
import com.displaynote.xmpp.client.support.XmppFunction;

import java.util.Date;

import static com.displaynote.xmpp.client.commands.msg.support.ReceiverPlatform.ANDROID;

/**
 * Created by alejandro on 10/10/17.
 */
public class CustomUpdateHandler implements XmppFunction<AddDeviceRequestPayload, AddDeviceRequestResultPayload> {

    @Override
    public AddDeviceRequestResultPayload apply(AddDeviceRequestPayload payload) throws XmppClientException {
        return new AddDeviceRequestResultPayload(new Date(), "myname", ANDROID);
    }

}

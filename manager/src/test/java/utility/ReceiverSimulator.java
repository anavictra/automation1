package utility;

import com.displaynote.xmpp.client.XmppClient;
import com.displaynote.xmpp.client.commands.CommandsComponent;
import com.displaynote.xmpp.client.commands.msg.register.AddDeviceRequestPayload;
import com.displaynote.xmpp.client.commands.msg.register.AddDeviceRequestResultPayload;
import com.displaynote.xmpp.client.commands.msg.support.ReceiverPlatform;
import com.displaynote.xmpp.client.commands.msg.support.ReceiverStatus;
import com.displaynote.xmpp.client.commands.msg.support.StatusInfo;
import com.displaynote.xmpp.client.exceptions.XmppServiceException;
import com.displaynote.xmpp.client.meetings.MeetingsComponent;
import com.displaynote.xmpp.client.support.XmppConfiguration;
import com.displaynote.xmpp.client.support.XmppFunction;
import com.displaynote.xmpp.client.support.XmppUserLogin;
import com.google.common.base.Strings;

import java.util.Date;
import java.util.UUID;

/**
 * Created by alejandro on 09/10/17.
 */
public class ReceiverSimulator {

    private static final String XMPP_DEVEL = "xmpp-devel.displaynote.com";
    private static final String XMPP_STG = "xmpp-stg.displaynote.com";
    private static final int XMPP_DEVEL_PORT = 443;
    private static final String XMPP_DOMAIN = XMPP_STG;
    private static final String XMPP_SERVER = XMPP_STG;
    private static final int XMPP_PORT = XMPP_DEVEL_PORT;
    private static XmppClient xmppClientTest;
    private static String pinCode;


    public static void startXmppClient(String serialNumber, String password) throws XmppServiceException {
        XmppConfiguration xmppConfiguration = new XmppConfiguration();
        XmppClient xmppClient = new XmppClient(xmppConfiguration);

        xmppConfiguration.setDebug(true);
        xmppConfiguration.setSslTrustAll(true);
        xmppConfiguration.setPacketReplyTimeout(5_000);
        xmppConfiguration.setResponseTimeout(5_000);

        CommandsComponent commandsComponent = new CommandsComponent(xmppClient);
        xmppClient.registerComponent(commandsComponent);
        MeetingsComponent meetingsComponent = new MeetingsComponent(xmppClient);
        xmppClient.registerComponent(meetingsComponent);

        xmppClient.start();
        XmppUserLogin login = XmppUserLogin.builder()
                .node(serialNumber) //MK80E38087E088928000 (Windows Receiver)
                .xmppDomain(XMPP_DOMAIN)
                .xmppServer(XMPP_SERVER)
                .xmppPort(XMPP_PORT)
                .password(password)
                .resource(UUID.randomUUID().toString())
                .build();
        xmppClient.login(login);
        xmppClientTest = xmppClient;
        commandsComponent.setStatus(
                new StatusInfo("0.0.0.12345", ReceiverPlatform.WINDOWS, ReceiverStatus.IDLE));

        /*XmppFunction<AddDeviceRequestPayload, AddDeviceRequestResultPayload> addDeviceRequestHandler =
                payload -> {
                    pinCode = payload.getCode();
                    System.out.println("Pin Code = " + payload.getCode());
                    return new AddDeviceRequestResultPayload(
                            new Date(), "best receiver", ReceiverPlatform.WINDOWS);

                };

        commandsComponent.setAddDeviceRequestHandler(addDeviceRequestHandler);*/

        commandsComponent.setAddDeviceRequestHandler(payload -> {
            pinCode = payload.getCode();
            System.out.println("Pin Code = " + payload.getCode());
            return new AddDeviceRequestResultPayload(
                    new Date(), "best receiver", ReceiverPlatform.WINDOWS);

        });


        //commandsComponent.setAddDeviceRequestHandler(new CustomUpdateHandler());

        boolean xmppAuthenticated = xmppClient.isXmppAuthenticated();
        System.out.println("xmppAuthenticated = " + xmppAuthenticated);
    }

    public static void closeXmppClient() {
        xmppClientTest.terminate();
    }


    public static String getCode() {
        if (Strings.isNullOrEmpty(pinCode)) {
            return null;
        } else {
            return pinCode;
        }
    }


}

package com.ad364.integrate_kie;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.ad364.bc_tables.OperatingSystem;
import com.ad364.bc_tables.Recommendation;
import com.ad364.bc_tables.TravelProfile;
import org.kie.api.KieServices;
import org.kie.api.command.BatchExecutionCommand;
import org.kie.api.command.Command;
import org.kie.api.command.KieCommands;
import org.kie.api.runtime.ExecutionResults;
import org.kie.server.api.marshalling.MarshallingFormat;
import org.kie.server.api.model.ServiceResponse;
import org.kie.server.client.CredentialsProvider;
import org.kie.server.client.KieServicesClient;
import org.kie.server.client.KieServicesConfiguration;
import org.kie.server.client.KieServicesFactory;
import org.kie.server.client.RuleServicesClient;
import org.kie.server.client.credentials.EnteredCredentialsProvider;

public class Main {

    private static final String KIE_SERVER_URL = "http://localhost:8080/kie-server/services/rest/server";
    // TODO: Credentials
    private static final String USERNAME = "";
    private static final String PASSWORD = "";
    private static final String CONTAINER_ID = "";

    public static void main(String[] args) {
        /** TODO: Configure the KieServicesConfig object
         *   - Use the username and password to authenticate
         *   - Set marshalling to JSON
         */
        CredentialsProvider credentialsProvider = null;
        KieServicesConfiguration kieServicesConfig = null;
        addExtraClasses(kieServicesConfig);

        // TODO: Create a RuleServicesClient client
        KieServicesClient kieServicesClient = null;
        RuleServicesClient rulesClient = null;

        List<Command<?>> commands = new ArrayList<>();
        KieServices kieServices = KieServices.Factory.get();
        KieCommands commandFactory = kieServices.getCommands();
        /**
         * TODO commands:
         *  - insert an operating system and travel profile using the
         *    getOperatingSystem and getTravelProfile helper methods.
         *  - Insert the fireAllRules command.
         *  - Insert the getObjects command and set the identifier to objects
         *  - Insert the dispose command
         */

        BatchExecutionCommand batchExecutionCommand = commandFactory.newBatchExecution(commands);

        ServiceResponse<ExecutionResults> response = rulesClient.executeCommandsWithResults(CONTAINER_ID, batchExecutionCommand);
        ExecutionResults results = response.getResult();
        System.out.println(results.getValue("objects"));

    }

    /**
     * Adds classes for marshalling/unmarshalling.
     */
    private static void addExtraClasses(KieServicesConfiguration connectionConfig) {
        Set<Class<?>> extraClassList = new HashSet<>();
        extraClassList.add(OperatingSystem.class);
        extraClassList.add(Recommendation.class);
        extraClassList.add(TravelProfile.class);
        connectionConfig.addExtraClasses(extraClassList);
    }

    private static OperatingSystem getOperatingSystem(String name) {
        OperatingSystem operatingSystem = new OperatingSystem();
        operatingSystem.setOsName(name);
        return operatingSystem;
    }

    private static TravelProfile getTravelProfile(int travelPercent, boolean noTravel) {
        TravelProfile travelProfile = new TravelProfile();
        travelProfile.setTravelPercent(travelPercent);
        travelProfile.setNoTravel(noTravel);
        return travelProfile;
    }

}

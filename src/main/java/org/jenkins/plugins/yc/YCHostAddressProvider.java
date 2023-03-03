package org.jenkins.plugins.yc;

import yandex.cloud.api.compute.v1.InstanceOuterClass;

import java.util.Optional;

public class YCHostAddressProvider {

    public static String getPrivateIpAddress(YCComputer computer) throws Exception {
        YCAbstractSlave abstractSlave = computer.getNode();
        if(abstractSlave != null && abstractSlave.getInstanceId() != null) {
            InstanceOuterClass.Instance instance = Api.getInstanceResponse(abstractSlave.getInstanceId(), computer.getCloud());
            if (instance != null) {
                Optional<InstanceOuterClass.NetworkInterface> networkInterface = instance.getNetworkInterfacesList().stream().findFirst();
                if(networkInterface.isPresent()) {
                    return networkInterface.get().getPrimaryV4Address().getOneToOneNat().getAddress();
                }
            }
        }
        return "0.0.0.0";
    }
}

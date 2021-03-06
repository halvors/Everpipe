package gigaherz.everpipe.pipe.connectors.items;

import gigaherz.everpipe.Everpipe;
import gigaherz.everpipe.pipe.channels.ChannelType;
import gigaherz.everpipe.pipe.connectors.Connector;
import gigaherz.everpipe.pipe.connectors.ConnectorHandler;
import gigaherz.everpipe.pipe.connectors.ConnectorState;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.capabilities.Capability;

import javax.annotation.Nullable;

public class ItemHandlerConnector extends Connector {
    public static final ResourceLocation KEY = Everpipe.location("item_handler");

    protected ItemHandlerConnector(ConnectorHandler connectorType) {
        super(connectorType, ChannelType.ITEM);
    }

    @Override
    public ConnectorState immutableCopy() {
        return new State(getConnectorHandler(), this);
    }

    @Override
    public NBTTagCompound serializeNBT() {
        return super.serializeNBT();
    }

    @Override
    public void deserializeNBT(NBTTagCompound tag) {
        super.deserializeNBT(tag);
    }

    @Override
    public boolean hasCapability(Capability<?> capability, @Nullable EnumFacing facing) {
        return false;
    }

    @Override
    public <T> T getCapability(Capability<T> capability, @Nullable EnumFacing facing) {
        return null;
    }

    public static class State extends ConnectorState {
        // TODO: add item handler values for display

        public State(ConnectorHandler handler) {
            super(handler);
        }

        public State(State copyFrom) {
            super(copyFrom.getConnectorHandler());
        }

        public State(ConnectorHandler connectorHandler, ItemHandlerConnector copyFrom) {
            super(connectorHandler);
        }

        @Override
        public ConnectorState immutableCopy() {
            return new State(this);
        }

        @Override
        public void deserializeNBT(NBTTagCompound compound) {

        }
    }

    public static class Handler extends ConnectorHandler {
        public Handler() {
            setRegistryName(KEY);
        }

        @Override
        public Connector createInstance() {
            return new ItemHandlerConnector(this);
        }

        @Override
        public ConnectorState createStateInstance() {
            return new State(this);
        }
    }
}

package org.zafire.studios.vanillacore;

import org.bukkit.Location;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.zafire.studios.vanillacore.util.LocationSelector;

import be.seeseemelk.mockbukkit.MockBukkit;
import be.seeseemelk.mockbukkit.ServerMock;
import be.seeseemelk.mockbukkit.WorldMock;
import be.seeseemelk.mockbukkit.entity.PlayerMock;

@Disabled("MockBukkit doesn't support Paper API")
public class VanillaCoreTest {
    private ServerMock server;
    private VanillaCorePlugin plugin;
    private PlayerMock player;
    private WorldMock world;

    @BeforeAll
    public void setUp() {
        server = MockBukkit.mock();
        plugin = (VanillaCorePlugin) MockBukkit.load(VanillaCorePlugin.class);
        player = server.addPlayer("ZetaStormy");
        world = server.addSimpleWorld("world");
    }

    @Test
    public void testLocation() {
        LocationSelector locationSelector = plugin.getLocationSelector();
        Location location = locationSelector.getRandomLocation();
        location.setWorld(world);
        player.teleport(location);
        player.assertLocation(location, 10);
    }

    @AfterAll
    public void tearDown() {
        MockBukkit.unmock();
    }
}

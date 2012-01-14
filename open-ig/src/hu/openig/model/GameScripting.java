/*
 * Copyright 2008-2012, David Karnok 
 * The file is part of the Open Imperium Galactica project.
 * 
 * The code should be distributed under the LGPL license.
 * See http://www.gnu.org/licenses/lgpl.html for details.
 */

package hu.openig.model;

import hu.openig.core.Pair;
import hu.openig.utils.XElement;

import java.util.List;

/**
 * API to interact with a campaign scripting.
 * @author akarnokd, 2012.01.12.
 */
public interface GameScripting {
	/**
	 * Returns the list of video messages to send.
	 * @return the list of video messages to send.
	 */
	List<VideoMessage> getSendMessages();
	/**
	 * Returns the list of video messages to receive.
	 * @return the list of video messages to receive.
	 */
	List<VideoMessage> getReceiveMessages();
	/**
	 * Returns the list of current objectives.
	 * @return List of current objectives.
	 */
	List<Objective> currentObjectives();
	/**
	 * Initialize the scripting for the world and configuration.
	 * @param world the current world fully loaded
	 * @param in the script configuration
	 */
	void init(World world, XElement in);
	/**
	 * Close the scripting and release resources.
	 */
	void done();
	/**
	 * Load the scripting state from XML.
	 * @param in the input XML
	 */
	void load(XElement in);
	/**
	 * Save the scripting state into an XML.
	 * @param out the output XML
	 */
	void save(XElement out);
	/**
	 * Notification about research complete.
	 * @param player the player
	 * @param rt the research
	 */
	void onResearched(Player player, ResearchType rt);
	/**
	 * Notification about production complete.
	 * @param player the player
	 * @param rt the research type
	 */
	void onProduced(Player player, ResearchType rt);
	/**
	 * Notification about the destruction of a fleet.
	 * @param winner the winner fleet
	 * @param loser the loser fleet
	 */
	void onDestroyed(Fleet winner, Fleet loser);
	/**
	 * Notification about a planet colonized.
	 * @param planet the planet
	 */
	void onColonized(Planet planet);
	/**
	 * Notification about a planet conquered.
	 * @param planet the planet
	 * @param previousOwner the previous owner of the planet
	 */
	void onConquered(Planet planet, Player previousOwner);
	/**
	 * Notification about a player beaten.
	 * @param player the player
	 */
	void onPlayerBeaten(Player player);
	/**
	 * Notification about a player discovering a planet.
	 * @param player the player
	 * @param planet the planet
	 */
	void onDiscovered(Player player, Planet planet);
	/**
	 * Notification about a player discovering another player.
	 * @param player the player
	 * @param other the discovered player
	 */
	void onDiscovered(Player player, Player other);
	/**
	 * Notification about a player discovering another player's fleet.
	 * @param player the player
	 * @param fleet the fleet
	 */
	void onDiscovered(Player player, Fleet fleet);
	/**
	 * Notification about a player losing sight of a fleet.
	 * @param player the player
	 * @param fleet another player's fleet
	 */
	void onLostSight(Player player, Fleet fleet);
	/**
	 * Notification about a fleet arriving at a specific location.
	 * @param fleet the fleet
	 * @param x the X coordinate
	 * @param y the Y coordinate
	 */
	void onFleetAt(Fleet fleet, double x, double y);
	/**
	 * Notification about a fleet catching up to another fleet.
	 * @param fleet the fleet
	 * @param other the other fleet
	 */
	void onFleetAt(Fleet fleet, Fleet other);
	/**
	 * Notification about a fleet reaching a planet.
	 * @param fleet the fleet
	 * @param planet the planet
	 */
	void onFleetAt(Fleet fleet, Planet planet);
	/**
	 * Notification about a stance change. 
	 * @param first the player experiencing the stance change
	 * @param second the other player
	 */
	void onStance(Player first, Player second);
	/**
	 * Notification about an alliance between two players against another.
	 * @param first the first player
	 * @param second the second playeyr
	 * @param commonEnemy the common enemy
	 */
	void onAllyAgainst(Player first, Player second, Player commonEnemy);
	/**
	 * Notification about a battle completion.
	 * @param player the player
	 * @param battle the battle containing an outcome
	 */
	void onBattleComplete(Player player, BattleInfo battle);
	/**
	 * Notification about a time progress.
	 */
	void onTime();
	/**
	 * Notification about a building being completed.
	 * @param planet the planet
	 * @param building the building
	 */
	void onBuildingComplete(Planet planet, Building building);
	/**
	 * Notification about a building fully repaired.
	 * @param planet the planet
	 * @param building the building
	 */
	void onRepairComplete(Planet planet, Building building);
	/**
	 * Notification about upgrading a building.
	 * <p>Called before the building upgrade is actually started simulation, e.g., the building
	 * parameter represents the pre-upgrade state of the building.</p>
	 * @param planet the planet
	 * @param building the building
	 * @param newLevel the new level
	 */
	void onUpgrading(Planet planet, Building building, int newLevel);
	/**
	 * Notification about an inventory item added to a planet.
	 * @param planet the planet
	 * @param item the inventory item
	 */
	void onInventoryAdd(Planet planet, InventoryItem item);
	/**
	 * Notification about an inventory item added to a planet.
	 * @param planet the planet
	 * @param item the item
	 */
	void onInventoryRemove(Planet planet, InventoryItem item);
	/**
	 * Notification about a planet lost.
	 * <p>Called just before the planet dies.</p>
	 * @param planet the planet
	 */
	void onLost(Planet planet);
	/**
	 * Notification about a fleet lost.
	 * @param fleet the fleet
	 */
	void onLost(Fleet fleet);
	/** 
	 * Notification about a full screen video playback completed.
	 * @param video the video that has completed 
	 */
	void onVideoComplete(String video);
	/**
	 * Notification about a sound playback completed.
	 * @param audio the audio
	 */
	void onSoundComplete(String audio);
	/**
	 * Notification about a planet infection.
	 * @param planet the planet
	 */
	void onPlanetInfected(Planet planet);
	/**
	 * Notification about a planet cured.
	 * @param planet the planet
	 */
	void onPlanetCured(Planet planet);
	/**
	 * Notification about the user watched a message.
	 * @param id the message id
	 */
	void onMessageSeen(String id);
	/**
	 * Notification about a new game start.
	 */
	void onNewGame();
	/** Notify the scripting that a level jump occurred. */
	void onLevelChanged();
	/**
	 * Called once the structures are laid out.
	 * @param war the battle context
	 */
	void onSpacewarStart(SpacewarWorld war);
	/**
	 * Called after each step in the spacewar.
	 * @param war the battle context
	 */
	void onSpacewarStep(SpacewarWorld war);
	/**
	 * Called once the battle is concluded but before going to the next phase.
	 * @param war the battle context
	 */
	void onSpacewarFinish(SpacewarWorld war);
	/**
	 * Called once the player placed its own units and the AI did its own placements.
	 * @param war the battle context
	 */
	void onGroundwarStart(GroundwarWorld war);
	/**
	 * Called after each battle step.
	 * @param war the battle context
	 */
	void onGroundwarStep(GroundwarWorld war);
	/**
	 * Called once the battle is concluded but before going to the next phase.
	 * @param war the battle context
	 */
	void onGroundwarFinish(GroundwarWorld war);
	/**
	 * Test if the user should be able to control a particular own fleet.
	 * <p>Used by escort-like missions.</p>
	 * @param f the fleet
	 * @return true if may control
	 */
	boolean mayControlFleet(Fleet f);
	/**
	 * Returns true if the game can be auto saved.
	 * @return true if can auto saved
	 */
	boolean mayAutoSave();
	/**
	 * Returns the background image resource id and the battle reward string.
	 * @param battle the battle
	 * @return pair of background image resource id and the battle reward text,
	 * null if no special condition on any part
	 */
	Pair<String, String> battleReward(BattleInfo battle);
}

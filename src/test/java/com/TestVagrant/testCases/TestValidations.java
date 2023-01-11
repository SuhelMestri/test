package com.TestVagrant.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.payLoad.rcbTeam.rcbTeamData;

import io.restassured.path.json.JsonPath;

public class TestValidations {

	@Test

	public void foreignPlayersValidation() {

		JsonPath js = new JsonPath(rcbTeamData.payLoad());
		int totalPlayers = js.getInt("player.size()");

		int CountOfForeinPlayers = 0;
		
		for (int i = 0; i < totalPlayers; i++) 
		{
			String countryName = js.getString("player[" + i + "].country");
			if (!countryName.equalsIgnoreCase("India")) {
				CountOfForeinPlayers++;
			}
		}
		Assert.assertTrue(CountOfForeinPlayers == 4,
				"Failure Message => The count of Foreign Players in RCB team is not 4");
	}

	@Test
	public void wicketKeeperValidation() {
		JsonPath js = new JsonPath(rcbTeamData.payLoad());
		int totalPlayers = js.getInt("player.size()");

		int CountOfWkeeper = 0;
		
		for (int i = 0; i < totalPlayers; i++) 
		{
			String Playerrole = js.getString("player[" + i + "].role");
			if (Playerrole.equalsIgnoreCase("Wicket-keeper")) {
				CountOfWkeeper++;
			}
		}
		Assert.assertTrue(CountOfWkeeper >= 1, "Failure Message => RCB team having no weeket keepers");
	}
}

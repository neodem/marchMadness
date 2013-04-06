USE madness;

DROP TABLE IF EXISTS madness.TournamentGame;
DROP TABLE IF EXISTS madness.TournamentTeam;
DROP TABLE IF EXISTS madness.Conference;
DROP TABLE IF EXISTS madness.Tournament;
DROP TABLE IF EXISTS madness.Game;
DROP TABLE IF EXISTS madness.TeamAttribute;
DROP TABLE IF EXISTS madness.Attribute;
DROP TABLE IF EXISTS madness.Team;


CREATE TABLE madness.Team (
  teamID bigint unsigned NOT NULL AUTO_INCREMENT,
  name varchar(20) NOT NULL,
  teamName varchar(40),
  school varchar(40),
  coach varchar(40),
  PRIMARY KEY (teamID)
)
ENGINE=InnoDB;

CREATE TABLE madness.Attribute (
  attributeID bigint unsigned NOT NULL AUTO_INCREMENT,
  name varchar(60),
  PRIMARY KEY (attributeID)
)
ENGINE=InnoDB;

CREATE TABLE madness.TeamAttribute (
teamAttributeID bigint unsigned NOT NULL AUTO_INCREMENT,
  attributeID bigint unsigned NOT NULL,
  teamID bigint unsigned NOT NULL,
  value int,
    CONSTRAINT FK_TA_Team FOREIGN KEY (teamID) REFERENCES Team(teamID),
  CONSTRAINT FK_TA_Attribute FOREIGN KEY (attributeID) REFERENCES Attribute(attributeID),
  PRIMARY KEY (teamAttributeID)
)
ENGINE=InnoDB;

CREATE TABLE madness.Game (
  gameID bigint unsigned NOT NULL AUTO_INCREMENT,
  aTeam bigint unsigned NOT NULL,
  bTeam bigint unsigned NOT NULL,
  winnerID bigint unsigned,
  CONSTRAINT FK_aTeam FOREIGN KEY (aTeam) REFERENCES Team(teamID),
  CONSTRAINT FK_bTeam FOREIGN KEY (bTeam) REFERENCES Team(teamID),
  CONSTRAINT FK_winner FOREIGN KEY (winnerID) REFERENCES Team(teamID),
  PRIMARY KEY (gameID)
)
ENGINE=InnoDB;

CREATE TABLE madness.Tournament (
  tournamentID bigint unsigned NOT NULL AUTO_INCREMENT,
  date datetime,
  notes mediumtext,
  PRIMARY KEY (tournamentID)
)
ENGINE=InnoDB;

CREATE TABLE madness.Conference (
  conferenceID int unsigned NOT NULL AUTO_INCREMENT,
  name varchar(40) NOT NULL,
  PRIMARY KEY (conferenceID)
)
ENGINE=InnoDB;

CREATE TABLE madness.TournamentTeam (
  tournamentTeamID bigint unsigned NOT NULL AUTO_INCREMENT,
  teamID bigint unsigned NOT NULL,
  seed int NOT NULL,
  conference int unsigned NOT NULL,
  PRIMARY KEY (tournamentTeamID),
  CONSTRAINT FK_tournamentTeam_conference FOREIGN KEY (conference) REFERENCES Conference(conferenceID),
  CONSTRAINT FK_tournamentTeam_Team FOREIGN KEY (teamID) REFERENCES Team(teamID)
  )
ENGINE=InnoDB;

CREATE TABLE madness.TournamentGame (
  tournamentGameID bigint unsigned NOT NULL AUTO_INCREMENT,
  gameID bigint unsigned,
  tournamentID bigint unsigned,
  conference int unsigned,
  round int,
  spot int,
  CONSTRAINT FK_game_conference FOREIGN KEY (conference) REFERENCES Conference(conferenceID),
  CONSTRAINT FK_run FOREIGN KEY (tournamentID) REFERENCES Tournament(tournamentID) ON DELETE CASCADE ON UPDATE CASCADE,
  PRIMARY KEY (tournamentGameID)

)
ENGINE=InnoDB;
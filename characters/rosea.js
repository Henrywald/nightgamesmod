{
	"type" : "NPC",
	"name" : "Rosea",
	"outfit" : {
		"top" : ["vinedress", "leafbra"],
		"bottom" : ["vinethong"]
	},
	"stats" : {
		"base" : {
			"level" : 10,
			"attributes" : {
				"Seduction" : 10,
				"Cunning" : 7,
				"Power" : 5,
				"Bio" : 5
			},
			"resources" : {
				"stamina" : 100,
				"mojo" : 100,
				"arousal" : 150,
				"willpower" : 100
			}
		},
		"growth" : {
			"resources" : {
				"stamina" : 2,
				"bonusStamina" : 1,
				"mojo" : 2,
				"bonusMojo" : 1,
				"arousal" : 2,
				"bonusArousal" : 1,
				"willpower" : 1.5,
				"bonusWillpower" : 0.5
			},
			"traits" : [{
					"level" : 12,
					"trait" : "silvertongue"
				}
			],
			"preferredAttributes" : [{
					"attribute" : "Bio",
					"max" : 50
				}, {
					"attribute" : "Seduction"
				}
			]
		}
	},
	"traits" : [
		"dryad",
		"immobile"
	],
	"tactics" : "hunting",
	"body" : {
		"gender" : "female",
		"parts" : [{
				"type" : "nightgames.characters.body.PussyPart",
				"enum" : "plant"
			}, {
				"type" : "nightgames.characters.body.BreastPart",
				"enum" : "dd"
			}
		]
	},
	"items" : {
		"initial" : [{
				"item" : "semen",
				"amount" : 10
			}
		],
		"purchase" : [{
				"item" : "semen",
				"amount" : 10
			}, {
				"item" : "dildo",
				"amount" : 1
			}
		]
	},
	"lines" : {
		"hurt" : [{
				"requirements" :
				[{
						"trait" : "succubus"
					}
				],
				"text" : "<b>\"imma drain ya\"</b>"
			}, {
				"requirements" :
				[{
						"level" : 20
					}
				],
				"text" : "<b>\"imma hurt ya\"</b>"
			}, {
				"text" : "<b>\"u wot m8\"</b>"
			}
		],
		"naked" : [{
				"text" : "<b>\"u wot m8\"</b>"
			}
		],
		"stunned" : [{
				"text" : "<b>\"u wot m8\"</b>"
			}
		],
		"taunt" : [{
				"text" : "\"What the fuck did you just fucking say about me, you little bitch?<br>I’ll have you know I graduated top of my class in the Navy Seals, and I’ve been involved in numerous secret raids on Al-Quaeda, and I have over 300 confirmed kills.<br>I am trained in gorilla warfare and I’m the top sniper in the entire US armed forces. You are nothing to me but just another target. I will wipe you the fuck out with precision the likes of which has never been seen before on this Earth, mark my fucking words. You think you can get away with saying that shit to me over the Internet?<br>Think again, fucker.<br>As we speak I am contacting my secret network of spies across the USA and your IP is being traced right now so you better prepare for the storm, maggot.<br>The storm that wipes out the pathetic little thing you call your life.<br>You’re fucking dead, kid.<br>I can be anywhere, anytime, and I can kill you in over seven hundred ways, and that’s just with my bare hands.<br>Not only am I extensively trained in unarmed combat, but I have access to the entire arsenal of the United States Marine Corps and I will use it to its full extent to wipe your miserable ass off the face of the continent, you little shit.<br>If only you could have known what unholy retribution your little \"clever\" comment was about to bring down upon you, maybe you would have held your fucking tongue.<br>But you couldn’t, you didn’t, and now you’re paying the price, you goddamn idiot.<br>I will shit fury all over you and you will drown in it.<br>You’re fucking dead, kiddo.\""
			}
		],
		"tempt" : [{
				"text" : "<b>\"u wot m8\"</b>"
			}
		],
		"orgasm" : [{
				"text" : "I came, I saw, I came again."
			}
		],
		"makeOrgasm" : [{
				"text" : "I made you kumquat."
			}
		],
		"describe" : [{
				"text" : "<b>\"u wot m8\"</b>"
			}
		],
		"startBattle" : [{
				"text" : "<b>\"u gonna go down dawg\"</b>"
			}
		],
		"night" : [{
				"text" : "Rosea sees you after the fight cuz she wubs u. (highest affection)"
			}
		],
		"victory" : [{
				"requirements" :
				[{
						"result" : "anal"
					}, {
						"inserted" : "self"
					}
				],
				"text" : "She wins by fucking your ass"
			}, {
				"requirements" :
				[{
						"result" : "anal"
					}, {
						"inserted" : "other"
					}
				],
				"text" : "She wins by you fucking her ass"
			}, {
				"requirements" :
				[{
						"result" : "intercourse"
					}
				],
				"text" : "She wins by fucking you"
			}, {
				"text" : "Default NPC victory scene"
			}
		],
		"defeat" : [{
				"text" : "Default player victory scene"
			}
		],
		"draw" : [{
				"text" : "Default draw scene"
			}
		],
		"defeat" : [{
				"text" : "Default player victory scene"
			}
		],
		"victory3p" : [{
				"requirement" : [{
						"human" : "target"
					}
				],
				"text" : "Rosea brings you to an orgasm while {other:subject} holds you down."
			}, {
				"text" : "Rosea brings {other:name-do} to an orgasm while you hold {other:direct-object} down."
			}
		],
		"intervene3p" : [{
				"requirement" : [{
						"human" : "target"
					}
				],
				"text" : "While the fight is happening between you and {other:subject}, Rosea sneaks up behind you and holds you down."
			}, {
				"text" : "While the fight is happening, Rosea sneaks behind {other:name-do} and holds {other:direct-object} down."
			}
		],
		"mood" : {
			"dominant" : 100,
			"nervous" : 100,
			"angry" : 100,
			"confident" : 100,
			"horny" : 100,
			"desperate" : 100
		},
		"portraits" : [{
				"requirement" : [{
						"mood" : "dominant"
					}
				],
				"file" : "rosea_dominant.png"
			}, {
				"requirement" : [{
						"mood" : "nervous"
					}
				],
				"file" : "rosea_nervous.png"
			}, {
				"requirement" : [{
						"mood" : "angry"
					}
				],
				"file" : "rosea_angry.png"
			}, {
				"requirement" : [{
						"mood" : "confident"
					}
				],
				"file" : "rosea_confident.png"
			}, {
				"requirement" : [{
						"mood" : "horny"
					}
				],
				"file" : "rosea_horny.png"
			}, {
				"requirement" : [{
						"mood" : "desperate"
					}
				],
				"file" : "rosea_desperate.png"
			}
		],
		"defaultPortrait" : "rosea_desperate.png"
	}
}
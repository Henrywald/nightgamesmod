package nightgames.characters;

import java.util.Optional;

import nightgames.characters.body.BreastsPart;
import nightgames.characters.body.CockMod;
import nightgames.characters.body.EarPart;
import nightgames.characters.body.PussyPart;
import nightgames.characters.body.TailPart;
import nightgames.characters.body.WingsPart;
import nightgames.combat.Combat;
import nightgames.combat.Result;
import nightgames.global.Global;
import nightgames.global.Modifier;
import nightgames.items.Item;
import nightgames.items.clothing.Clothing;

public class Reyka extends BasePersonality {
	private static final long serialVersionUID = 8553663088141308399L;

	public Reyka() {
		super();
		this.character = new NPC("Reyka", 10, this);
		preferredCockMod = CockMod.incubus;
		this.character.outfitPlan.add(Clothing.getByID("tanktop"));
		this.character.outfitPlan.add(Clothing.getByID("miniskirt"));
		this.character.outfitPlan.add(Clothing.getByID("garters"));
		this.character.outfitPlan.add(Clothing.getByID("stilettopumps"));
		this.character.change(Modifier.normal);
		this.character.set(Attribute.Dark, 12);
		this.character.set(Attribute.Seduction, 14);
		this.character.set(Attribute.Cunning, 7);
		this.character.set(Attribute.Speed, 5);
		this.character.setTrophy(Item.ReykaTrophy);
		this.character.getStamina().setMax(40);
		this.character.getArousal().setMax(200);
		this.character.getMojo().setMax(70);
		character.add(Trait.succubus);
		character.add(Trait.proheels);
		character.add(Trait.masterheels);
		character.add(Trait.darkpromises);
		character.add(Trait.Confident);
		character.add(Trait.shameless);

		Global.gainSkills(this.character);

		character.plan = Plan.hunting;
		character.mood = Emotion.confident;
		character.body.add(BreastsPart.dd);
		character.body.add(PussyPart.succubus);
		character.body.add(TailPart.demonic);
		character.body.add(WingsPart.demonic);
		character.body.add(EarPart.pointed);
		character.body.finishBody(CharacterSex.female);
	}

	@Override
	public void setGrowth() {
		growth.stamina = 1;
		growth.arousal = 6;
		growth.mojo = 2;
		growth.bonusStamina = 1;
		growth.bonusArousal = 3;
		growth.bonusMojo = 2;
		preferredAttributes.add(c -> c.get(Attribute.Dark) < 50 
				&& c.get(Attribute.Dark) <= c.get(Attribute.Fetish) + 10
						? Optional.of(Attribute.Dark) : Optional.empty());
		preferredAttributes.add(c -> 
				c.get(Attribute.Dark) > c.get(Attribute.Fetish) + 10
				&& c.get(Attribute.Fetish) < 50
						? Optional.of(Attribute.Fetish) : Optional.empty());
		preferredAttributes.add(c -> Optional.of(Attribute.Seduction));
		growth.addTrait(2, Trait.pussyTraining1);
		growth.addTrait(5, Trait.tongueTraining1);
		growth.addTrait(8, Trait.expertGoogler);
		growth.addTrait(11, Trait.addictivefluids);
		growth.addTrait(14, Trait.graceful);
		growth.addTrait(17, Trait.insertion);
		growth.addTrait(20, Trait.spiritphage);
		growth.addTrait(23, Trait.tongueTraining2);
		growth.addTrait(26, Trait.magicEyeTrance);
		growth.addTrait(29, Trait.dickhandler);
		growth.addTrait(32, Trait.lacedjuices);
		growth.addTrait(35, Trait.energydrain);
		growth.addTrait(38, Trait.experttongue);
		growth.addTrait(41, Trait.soulsucker);
		growth.addTrait(44, Trait.analTraining1);
		growth.addTrait(47, Trait.desensitized);
		growth.addTrait(50, Trait.pussyTraining2);
		growth.addTrait(53, Trait.vaginaltongue);
		growth.addTrait(56, Trait.desensitized2);
	}

	@Override
	public void rest() {
		super.rest();
		if(!(character.has(Item.Dildo)||character.has(Item.Dildo2))&&character.money>=250){
			character.gain(Item.Dildo);
			character.money-=250;
		}
		if(!(character.has(Item.Tickler)||character.has(Item.Tickler2))&&character.money>=300){
			character.gain(Item.Tickler);
			character.money-=300;
		}
		if(!(character.has(Item.Strapon)||character.has(Item.Strapon2))&&character.money>=600){
			character.gain(Item.Strapon);
			character.money-=600;
		}
		if(character.money>0){
			Global.getDay().visit("Body Shop", character, Global.random(character.money));
		}
		if(character.money>0){
			Global.getDay().visit("XXX Store", character, Global.random(character.money));
		}
		if(character.money>0){
			Global.getDay().visit("Black Market", character, Global.random(character.money));	
		}
		Decider.visit(character);
		int r;
		for(int i=0;i<10;i++){
			r=Global.random(4);
			if(r==1){
				if(character.has(Trait.fitnessNut)){
					character.getStamina().gain(2);
				}
				character.getStamina().gain(2);
			}
			else if(r==3){
				if(character.has(Trait.expertGoogler)){
					character.getArousal().gain(8);
				}
				character.getArousal().gain(8);
			}
			else if(r==2){
				if(character.has(Trait.mojoMaster)){
					character.getMojo().gain(1);
				}
				character.getMojo().gain(2);
			}
		}
		character.gain(Item.semen, Global.random(3) + 1);
		buyUpTo(Item.semen, 5);
	}

	@Override
	public String bbLiner(Combat c) {
		return "Reyka looks at you with a pang of regret: <i>\"In hindsight, damaging"
				+ " the source of my meal might not have been the best idea...\"</i>";
	}

	@Override
	public String nakedLiner(Combat c) {
		return "<i>\"You could have just asked, you know.\"</i> As you gaze upon her naked form,"
				+ " noticing the radiant ruby ardorning her bellybutton, you feel"
				+ " sorely tempted to just give in to your desires. The hungry look"
				+ " on her face as she licks her lips, though, quickly dissuades you"
				+ " from doing so";
	}

	@Override
	public String stunLiner(Combat c) {
		return "Reyka is laying on the floor, her wings spread out behind her,"
				+ " panting for breath";
	}

	@Override
	public String taunt(Combat c) {
		return "\"You look like you will taste nice. Maybe if let me have "
				+ "a taste, I will be nice to you too.\"";
	}

	@Override
	public String temptLiner(Combat c) {
		return "\"Why keep fighting? Wouldn't it just feel SO much better just to let me do what I do best?\"";
	}

	@Override
	public String victory(Combat c,Result flag) {
		Character opponent = (this.character.equals(c.p1) ? c.p2 : c.p1);
		if(flag==Result.anal){
			return "Reyka alternates between long hard thrusts and sensual grinding to keep you from getting used to the stimulation, and the pleasure it is " +
			"inflicting on you stops you from mustering the resolve to fight back. <i>\"I do love a good bit of pegging.\"</i> Reyka comments as she begins " +
			"to gently rock the head of the strapon over your prostate, leaving you breathing hard as your mouth hangs open. <i>\"There's a special " +
			"pleasure in making a boy a little butt slave.\"</i> Her words shock you and cause your resistance to slip a little. <i>\"Hmmm?\"</i> She purrs <i>\"Would " +
			"you like that?\"</i> she asks, picking up the pace of her thrusting. <i>\"To be my little pet boy slut?\"</i> Your only response is to cum. Hard. Ropes " +
			"of cum fall to the ground below you.<p>Reyka pouts as she pulls out <i>\"Such a good waste of semen though.\"</i> she tuts. <i>\"Looks like you " +
			"still owe me a meal.\"</i> She smirks in a way that makes your eyes flash quickly left to right, looking for an escape route. Reyka is too quick " +
			"however and soon you find yourself pinned with your still hard cock buried deep in her pussy.<p>She rides you until you cum again and she " +
			"has cum twice herself. She stands up and begins collecting her clothes and her spoils as the victor. She turns to you. <i>\"The offer still " +
			"stands; you'd make a great sub if you're ever interesting in broadening your sexual horizons. Open minded men are hard to find.\"</i> She admits " +
			"smiling. You shake your head; you don't think that sort of thing would really suit you. Her smile deflates some but she nods her head and " +
			"turns to go. <i>\"Let me know if that ever changes, I'd definitely enjoy opening your mind,\"</i> she calls over her shoulder as she leaves.";
		}
		character.arousal.empty();
		return "With a final cry of defeat (and pleasure) you erupt under Reyka's"
				+ " attentions. She immediatly pounces on you and draws your lips to hers."
				+ " As does so, she inhales deeply, drawing more than just air out of you."
				+ " You feel your strength flowing into her and even though your vision"
				+ " is already darkening, you see her starting to literally glow, surrounded"
				+ " by a soft, deep red aura. As she continues to drink in your energy,"
				+ " you feel something shift in you, as if something that was there all"
				+ " along but has always gone unnoticed by you suddenly got yanked on."
				+ " Just before you pass out, you see her wings enveloping you both"
				+ " in a dark, warm cocoon.<p> After what seems like an eternity,"
				+ " but what actually lasted for only a few minutes, you wake up and"
				+ " drowsily look around. You can see Reyka sitting cross-legged a few feet"
				+ " away, her wings folded neatly behind her back and her eyes fixed on"
				+ " yours."
				+ (opponent.hasDick() ? " You notice a bottle of pearly"
						+ " white liquid behind her and can only guess where it came from."
						: "")
				+ " <i>\"You tasted heavenly\"</i>, she says, while you are still too"
				+ " far gone to catch on to the irony of the statement, <i>\"So here I was,"
				+ " drinking in your delicous energy, and it struck me that if I claimed"
				+ " your soul now, I wouldn't be able to drink from you again. So I simply"
				+ " took a little nibble into it and let you recover. I will expect you to"
				+ " repay this kindness soon, and there is only one thing I will accept"
				+ " as payment. I'll leave you to figure out what it is.\"</i><p> With that,"
				+ " she walks off, her hips, barely covered by her short miniskirt,"
				+ " seductively waving good-bye. For now.";
	}

	@Override
	public String defeat(Combat paramCombat,Result flag) {
		character.arousal.empty();
		if(character.has(Trait.succubus)&&character.get(Attribute.Dark)>=6){
			return "Reyka shivers as she approaches her climax and her legs fall open defenselessly. You can't resist taking advantage of this opening to deliver the " +
					"coup de grace. You grab hold of her thighs and run your tongue across her wet pussy. Her love juice is surprisingly sweet and almost intoxicating, " +
					"but you stay focused on your goal. You ravage her vulnerable love button with your tongue and a flood of tasty wetness hits you as she cums. You " +
					"prolong her climax by continuing to lick her while lapping up as much of her love juice as you can. The taste seems almost familiar, but you can't " +
					"quite place it. Sweet and tangy like a desert wine? Not a perfect comparison, but not far off.<p>Reyka should be coming down from her peak, but " +
					"she's still moaning quite passionately. Oh well, it can't hurt to drink up the last of her love juice. You're the one who made her juice herself, so " +
					"it seems only fair. It is very tasty. Intoxicating was the word that came to mind early, but addictive seems to fit too. Reyka's flower is mostly " +
					"clean, but you stick your tongue deep inside to be sure. There seems to be some fresh love juice in this bit... and this one.... Here too.<p>Reyka's " +
					"pussy tenses up and you're treated to another flood of her wonderful flavor. You can't let this much juice go to waste. You diligantly continue to " +
					"lick Reyka's trembling girl parts as she squeals in passion. You feel her hands grip your hair desperately and you have to hold her hips to keep her " +
					"from squirming away. She's producing a decent amount of delicious nectar, but it occurs to you that she'll probably give you more if you focus on her " +
					"clit. You target her pearl and lick it rapidly until she screams in pleasure and rewards you with another surge of juice. This seems like the best " +
					"way to get more of her wonderful juice. You could just stay here drinking this stuff all night, and you just may.<p>You suddenly feel Reyka's tail wrap " +
					"tightly around your balls. Your head jerks up in surprise and her thighs clamp together on it, holding you out of reach of her delicious honey pot. " +
					"<i>\"Down lover\"</i> Reyka admonishes you as she covers her groin protectively. <i>\"I appreciate the dedication, but after a couple orgasms, I need a chance to " +
					"catch my breath.\"</i> You feel your head clear a bit and realize you completely fell victim to her addictive love juice.<p>Reyka uses her grip on your " +
					"head to force you onto your back. <i>\"I do love being eaten out, but right now I'm ready to be filled.\"</i> She releases the head scissor and positions herself " +
					"over your dick before dropping her hips to engulf you to the hilt. A jolt goes through you and you realize exactly how horny you are. I addition to " +
					"not having any relief, Reyka's fluids have started to affect you. You're incredibly hard and sensitive, but even though Reyka is riding you intensely, " +
					"your ejaculation feels painfully out of reach. You don't feel your climax start to build until Reyka is moaning and approaching yet another orgasm. Is " +
					"that an innate succubus ability? Is she controlling the timing of your orgasm? You don't have time to dwell on the question, your hips thrust involuntarily " +
					"as you shoot your load into her waiting quim. Reyka gives you a deep, passionate kiss as she gets off of you. <i>\"Thanks lover. You sure know how to show a " +
					"girl a good time.\"</i>";
		}
		return "As you bring Reyka ever closer to her climax, her prehensile"
				+ " tail suddenly pulls you to the ground and coils around your neck."
				+ " She squats down over your face and uses her tail to push your face"
				+ " up against her pussy. The scent is so enticing that you simply must"
				+ " have a taste, and you start lapping at her feverishly. Somewhere along"
				+ " the way her tail let go of your neck, the compulsion it provided having"
				+ " been replaced by that of her aphrodisac juices. As she finally screams out"
				+ " in orgasm, the sound reverberating through your soul, the amount of"
				+ " fluids gushing into your willing mouth nearly drown you. After a few"
				+ " seconds she rolls off of you, although you don't notice it, having passed"
				+ " out from the overdose of aphrodisiacs.<p>You come to your senses just"
				+ " in time to see Reyka drinking down the load of cum you are shooting"
				+ " into her mouth. Somehow, you keep from passing out as she drinks"
				+ " some of your energy and soon, you see her face hovering over yours."
				+ " <i>\"Sorry about that, but you wore me out so thoroughly I just needed"
				+ " a little snack to get back on my feet. You'll be perfectly fine in"
				+ " a few minutes, after that we can go back to hunting each other. I"
				+ " certainly hope we meet again soon, that treatment you gave me is well"
				+ " worth the trouble of fighting through the others to get at you.\"</i>"
				+ " As she walks away into the distance you can't help but feel like"
				+ " 'winning' is not quite the word you would use to describe what you"
				+ " just went through.";
	}

	@Override
	public String victory3p(Combat c, Character target, Character assist) {
		if (target.human()) {
			return "<i>\"How kind of you to hold him for me, dear.\"</i> Reyka bows her head ever so slightly towards "+assist.name()+" and then turns her gaze upon you prone form. " +
					"She pulls a blindfold out of a small pocket in her miniskirt and secures it tightly over your eyes. <i>\"Wouldn't want to spoil the surprise, would we?\"</i> For " +
					"just a moment, you feel a slight pull on you mind, but the sensation passes quickly, replaced by that of one of her slender fingers invading your mouth. " +
					"It is covered with a fragrant liquid and given what you already know about her, there is little doubt in your mind of its origins. Your suspicions " +
					"are proven correct when the ahrodisiac reaches your loins, which respond as expected. Appearantly not one to stand on ceremony, Reyka immediatly " +
					"settles over you now rock hard dick and lowers herself down onto it. The sensation is beyond comparison, her pussy wiggles and twists around you almost " +
					"as if it has a mind of its own, a mind connected to your own, knowing what will bring you the most pleasure. Your experiences in sex-fighting have " +
					"left you with impressive sexual stamina, but in the face of a succubus' unimpeded attentions, no man can hope to last. All too quickly you succumb " +
					"to the feelings, pouring your seed into the succubus. Just your seed. You where expecting her take so much more, but you just feel a little tired, " +
					"not more so than after a regular orgasm. The mystery is unveiled when Reyka removes the blindfold with her left hand. In her right hand, she is " +
					"holding a bottle. That bottle is firmly planted against the head of your still twitching dick and filled with your cum. <i>\"You looked scrumptuous, " +
					"sitting there all helpless, but I was really in need of some supplies. Still, I didn't want to deny you the pleasure, so I crafted a teeny tiny " +
					"illusion just for you.\"</i> As she says this, she pours a small drop of your semen onto her finger and licks it up. <i>\"Yum, I might just have to find " +
					"you again later.\"</i> Both she and "+assist.name()+" walk off, in opposite directions, the former holding your clothes and the latter quietly giggling at " +
					"your embarrassment. Ah, well.";
		}
		return "<i>\"My my, what a cute little offering you have caught for me tonight\"</i>, Reyka says, looking you at you with a satisfied grin on her face. <i>\"Not very nutricious, " +
				"but certainly a good deal of fun.\"</i> With that, she starts gently undressing "+target.name()+". When she is finished she squats down in front of her, bringing " +
				"her tail up between them. <i>\"Where would you prefer it dear?\"</i>, she asks "+target.name()+", whose eyes grow wide in shock. She manages to stammer out a " +
				"few syllables, but nothing quite coherent. \"No preference? Then I guess I will simply choose for you\" She brings her spade-tipped tail between "+target.name()+"s " +
				"legs and starts running the very tip rapidly across her labia. When it is sufficiently wet, she moves it slightly upwards and moves it briskly back and forth over " +
				target.name()+"'s clit.<p>"+target.name()+", at first scared, now has her eyes closed and begins moaning feverishly. Just when she has almost reached her climax, " +
				"Reyka digs her tail deep into "+target.name()+"'s drooling pussy. This sends "+target.name()+" loudly over the edge. Her screams of pleasure are almost deafening, " +
				"and you have to work really hard to restrain her convlusing body. After a minute or so, the orgasm subsides and "+target.name()+" falls asleep and you gently lay her " +
				"down. When you turn to look at "+character.name()+", you are startled by the predatory look in her eyes. <i>\"I'm afraid all the excitement has left me a tad peckish. Be a " +
				"dear and help me out with that, will you?\"</i> You ponder whether or not you made a mistake in helping her.";
	}

	@Override
	public String intervene3p(Combat c, Character target, Character assist) {
		if (target.human())
			return "Your fight with "
					+ assist.name()
					+ " starts out poorly; she already"
					+ " has you naked and aroused, wheras she seems as cool and calm as when"
					+ " you started. You haven't lost yet though, you just need to find an opening " +
					"and turn things around. A noise behind you causes you to turn and your vision is " +
					"filled with two piercing red eyes. <i>\"Kneel.\"</i> You drop to your knees involuntarily. " +
					"The rational part of your brain is telling you that Reyka is trying to dominate your " +
					"mind and you should resist, but what's the point? Reyka's tail binds your wrists and " +
					"she forces you to turn back to a bewildered "+assist.name()+". <i>\"I'm not poaching " +
					"your prey,\"</i> you hear her say. <i>\"He's all yours.\"</i>";

		return "Your fight with "
				+ target.name
				+ " starts out poorly; she already"
				+ " has you naked and aroused, wheras she seems as cool and calm as when"
				+ " you started. Fortune, though, seems to have a strange sense of humor as"
				+ " your salvation comes in the form of a winged demon swooping down on "
				+ target.name
				+ ". The two are briefly entangled in a ball of limbs and wings,"
				+ " but soon Reyka comes out on top. She is pinning "
				+ target.name
				+ " helplessly to the ground, holding her arms behind her back and"
				+ " locking her shoulders in place with her wings. The struggle has "
				+ "left " + target.name
				+ " completely naked and ready for you to"
				+ " take advantage of.";
	}

	@Override
	public String describe(Combat c) {
		return "Reyka the succubus stands before you, six feet tall with"
				+ " the most stunningly beautiful body you have ever seen."
				+ " Her long black hair enshrines her perfect face like a priceless"
				+ " painting. Her arms are slim and end in long-fingered,"
				+ " soft hands, nails polished shining red. Underneath, her long and"
				+ " perfectly formed legs and delicate feet stand in an imposing posture."
				+ " Behind her, you see a pair of relatively small but powerful-looking bat wings.<br>"
				+ " Her gaze speaks of indescribable pleasure, but your mind reminds you"
				+ " of the cost of indulging in a succubus' body: Give her half a chance"
				+ " and she will suck out your very soul.";
	}

	@Override
	public String draw(Combat paramCombat,Result flag) {
		return "As you and Reyka are both thrusting against each other for all you're worth, you feel your inevitable climax approaching very rapidly. Just " +
				"before you erupt into her, you notice a strange change come over her. Her tail and wings seem to evaporate before you and her white skin gains " +
				"a slight tan. The challenging look in her eyes and confident little smile are replaced by an expression of surprise and shock. But you don't notice " +
				"any of this. All you can see are her crimson irises giving way to a deep, radiant blue. Just as you spot what you think might be a single tear " +
				"forming in her right eye, both of you reach your orgasms. You were expecting to feel her power wash over you, to feel it pour into every nook " +
				"and cranny of your soul and then draw that soul out and into her, but none of that happens. The only sensations are the pure, tantric bliss of " +
				"simultaneous climax and a strange affection for the two deep blue eyes staring into yours. When eventually the paradise you found yourself in " +
				"once again gives way to the cold bitterness of reality and you see the first red spots already reappearing in Reyka's eyes, your " +
				"rapidly souring mood is mollified by her passionate, warm embrace. She just holds you like that, not speaking, not moving, even as the demonic parts " +
				"of her anatomy return to her shapely form. After a few minutes, which might as well have been days for you, she releases lets go of you, leans " +
				"back some and softly speaks the two words you least expected ever to hear from her: <i>\"Thank you.\"</i> With that, she leaves what few clothes she " +
				"usually wears, turns around and walks away. Not the domineering, seductively swaying stride you have grown used to, but rather a slower, more " +
				"composed walk with her head slightly bowed. You are absolutely perplexed by this rare display of emotion, but after a while you gather your wits " +
				"- and her clothes - and take off into the night. In the back of your mind, you know she will be back to hunt you down later, but this experience " +
				"will remain entrenched in you memory for quite some time.";
	}

	@Override
	public boolean fightFlight(Character paramCharacter) {
		return !this.character.mostlyNude() || Global.random(3) == 1;
	}

	@Override
	public boolean attack(Character paramCharacter) {
		return !this.character.mostlyNude() || Global.random(3) == 1;
	}
	public double dickPreference() {
		return 2;
	}

	@Override
	public String startBattle(Character other) {
		return "<i>\"Yum, I was just looking for a tasty little morsel.\"</i><p>"
				+ "Reyka strikes a seductive pose and the devilish smile"
				+ " on her face reveals just what, or more specifically,"
				+ " who she intends that morsel to be.";
	}

	@Override
	public boolean fit() {
		return (!this.character.mostlyNude() || Global.random(3) == 1)
				&& (this.character.getStamina().percent() >= 50)
				&& (this.character.getArousal().percent() <= 50);
	}

	@Override
	public String night() {
		return "You feel exhausted after yet another night of sexfighting. You're not complaining, of course; "+
				"what guy would when having this much sex with several different girls? Still, a weekend would "+
				"be nice sometime... About half way to your room, Reyka steps in front of you. Where did she come from? "+
				"<i>\"Listen, "+Global.getPlayer().name()+", I've been doing some thinking lately. You know very well I've had sex with a lot "+
				"of guys and a fair amount of girls, too, right?\"</i> You just nod, wondering where this is going. <i>\"Well, "+
				"in all that time no one has ever made me feel the way you can. I don't know why, really, but I can't help "+
				"feeling there's something special about you.\"</i> You stand there, paralyzed, with a look of amazement "+
				"on your face. Reyka intimidates you. Hell, she is downright terrifying at times. To see and hear "+
				"her like this is like nothing you had ever expected from her. For a moment, you think this is all some "+
				"elaborate trick of some sort, but that thought vanishes the instant you see tears welling in her eyes. "+
				"<i>\"I just... We demons aren't supposed to feel like this, you know? We don't form relationships. It's all "+
				"just a constant power struggle, constant scheming and looking over your shoulder and sleeping with a "+
				"knife under your pillow. It has never bothered me before; it's simply what I am. That's what I used to "+
				"think, anyway. Now, I'm not so sure... about anything...\"</i> She quitely sobs while saying this, and you "+
				"embrace her. You hold her there for some time, before inviting her to spend the night at your place. "+
				"You don't even have sex when you get there, you just both lay down in your single bed, close to "+
				"each other, and enjoy a peaceful sleep together with your arms around her and her head on your shoulder.";
	}
	
	public boolean checkMood(Combat c, Emotion mood, int value) {
		switch(mood){
		case dominant:
			return value>=50;
		case nervous:
			return value>=150;
		default:
			return value>=100;
		}
	}

	@Override
	public String orgasmLiner(Combat c) {
		return "Reyka shudders, <i>\"Mmm it's been a while since I've felt that. Here, I'll return the favor\"</i>";
	}

	@Override
	public String makeOrgasmLiner(Combat c) {
		return "With a devilish smile, Reyka brings her face close to yours <i>\"Mmmmm that smells great! Too bad I'm still pretty hungry.\"</i>";
	}
}

package nightgames.skills;

import nightgames.characters.Attribute;
import nightgames.characters.Character;
import nightgames.combat.Combat;
import nightgames.combat.Result;
import nightgames.global.Global;

public class CommandHurt extends PlayerCommand {

	public CommandHurt(Character self) {
		super("Force Pain", self);
	}

	@Override
	public String describe(Combat c) {
		return "Convince your thrall that running into the nearest wall is a good idea.";
	}

	@Override
	public boolean resolve(Combat c, Character target) {
		target.pain(c, Global.random(10) + target.get(Attribute.Speed));
		c.write(getSelf(),deal(c, 0, Result.normal, target));
		return true;
	}

	@Override
	public Skill copy(Character user) {
		return new CommandHurt(user);
	}

	@Override
	public Tactics type(Combat c) {
		return Tactics.damage;
	}

	@Override
	public String deal(Combat c, int magnitude, Result modifier, Character target) {
		return "Grinning, you point towards the nearest wall. " + target.name()
				+ " seems confused for a moment, but soon she understands your"
				+ " meaning and runs headfirst into it.";
	}

	@Override
	public String receive(Combat c, int magnitude, Result modifier, Character target) {
		return "<<This should not be displayed, please inform The"
				+ " Silver Bard: CommandHurt-receive>>";
	}

}

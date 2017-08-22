package fr.redpanda.pander.businesscode;

public class CreationEntities {

	protected Candidate candidate;
	protected Company company;
	protected Job job;
	protected Skill skillSoft;
	protected Skill skillTech;
	protected Skill skillOther;

	@Before
	public void setUp() {
		

		initDb();
		
		candidate = new Candidate("firstname@lastname.com", "firstname", "lastname");
		candidate.setPassword("hashedpassword");

		company = new Company("IMIE", "00000000000000", "firstname@imie.com", "https://imie-ecole-informatique.fr/");
		company.setPassword("hashedpassword");

		job = new Job("Developer");

		skillSoft = new Skill("Rigoureux", TypeSkill.SOFT);
		skillTech = new Skill("Java", TypeSkill.TECH);
		skillOther = new Skill("Gestion de projet", TypeSkill.TECH);

		List<Skill> skills = new ArrayList<>();
		skills.add(skillSoft);
		skills.add(skillTech);
		skills.add(skillOther);

		job.getSkills().addAll(skills);
		candidate.getSkills().addAll(skills);

		company.getJobs().add(job);

	}
	

}

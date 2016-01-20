package ctci.chapter4TreesAndGraphs;

import java.util.HashSet;
import java.util.Set;
import java.util.StringJoiner;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Benoit Piette on 6/01/2016.
 */
public class q7 {

    /*
    * Build order
    *
    * You are given a list of projects and a list of dependencies (which is a list of pairs of projects, where the
    * first project is dependent on the second project). All of a project's dependencies must be built before the
    * project is. Find a build order that will allow the projects to be built. If there is no valid build order,
    * return an error.
    *
    * EXAMPLE
    * Input:
    *   projects: a,b,c,d,e,f
    *   dependencies: (d,a), (b,f), (d,b), (a,f), (c,d)
    * Output: f,e,a,b,d,c
    *
    * */

    public String getBuildOrder(Set<Project> projects) throws CannotBuildException {
        StringJoiner sj = new StringJoiner(",");

        while (!projects.isEmpty()) {
            Project project = getNextProjectWithoutDependency(projects);

            if (project == null) {
                throw new CannotBuildException("Cannot build");
            }
            sj.add(project.name);
            removeAsDependency(projects, project);

        }

        return sj.toString();
    }


    public Project getNextProjectWithoutDependency(Set<Project> projects) {
        return projects.parallelStream().filter(project -> project.dependencies.isEmpty()).findFirst().orElse(null);
    }

    public Set<Project> removeAsDependency(Set<Project> projects, Project project) {
        projects.forEach(project1 -> project1.dependencies.remove(project));
        projects.remove(project);
        return projects;
    }

    @Test
    public void canBuildTest() throws CannotBuildException {
        Set<Project> projects = new HashSet<>();

        Project pa = new Project("a");
        Project pb = new Project("b");
        Project pc = new Project("c");
        Project pd = new Project("d");
        Project pe = new Project("e");
        Project pf = new Project("f");

        pd.addDependency(pa);
        pb.addDependency(pf);
        pd.addDependency(pb);
        pa.addDependency(pf);
        pc.addDependency(pd);

        projects.add(pa);
        projects.add(pb);
        projects.add(pc);
        projects.add(pd);
        projects.add(pe);
        projects.add(pf);
        Assert.assertNotNull(getBuildOrder(projects));
    }

    @Test(expected = CannotBuildException.class)
    public void cannotBuild() throws CannotBuildException {
        Project p1 = new Project("p1");
        Project p2 = new Project("p2");
        p1.addDependency(p2);
        p2.addDependency(p1);
        Set<Project> projects1 = new HashSet<>();
        projects1.add(p1);
        projects1.add(p2);

        System.out.println(getBuildOrder(projects1));
    }

    public static class Project {

        String name;

        Set<Project> dependencies = new HashSet<>();

        public Project(String name) {
            this.name = name;
        }

        public void addDependency(Project project) {
            this.dependencies.add(project);
        }
    }

    private static class CannotBuildException extends Exception {

        public CannotBuildException(String message) {
            super(message);
        }
    }
}

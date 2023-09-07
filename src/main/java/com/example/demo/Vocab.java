package com.example.demo;

import java.util.ArrayList;
import java.util.List;

public class Vocab {
    static List<Vocab> vocabList = new ArrayList<>();
    public  String word;
    public  String definition;
    public  Vocab(String word, String definition){
        this.word = word;
        this.definition = definition;
    }
    public static List<Vocab> generateVocab() {
        List<Vocab> vocabList = new ArrayList<>();
        vocabList.add(new Vocab("access token", "   A(n) ___ that is used in place of a password when performing Git operations over HTTPS with Git on the command line or the API. Also called a personal access token."));
        vocabList.add(new Vocab("blame", "  The ___ feature in Git describes the last modification to each line of a file, which generally displays the revision, author and time. This is helpful, for example, in tracking down when a feature was added, or which commit led to a particular bug."));
        vocabList.add(new Vocab("branch", " A(n) ___ is a parallel version of a repository. It is contained within the repository, but does not affect the primary or main branch allowing you to work freely without disrupting the \"live\" version. When you've made the changes you want to make, you can merge your branch back into the main branch to publish your changes."));
        vocabList.add(new Vocab("clone", "  A(n) ____ is a copy of a repository that lives on your computer instead of on a website's server somewhere, or the act of making that copy. When you make a clone, you can edit the files in your preferred editor and use Git to keep track of your changes without having to be online. The repository you cloned is still connected to the remote version so that you can push your local changes to the remote to keep them synced when you're online."));
        vocabList.add(new Vocab("collaborator","    A(n) ___ is a person with read and write access to a repository who has been invited to contribute by the repository owner."));
        vocabList.add(new Vocab("commit", " A(n) ___, or \"revision\", is an individual change to a file (or set of files). When you make a commit to save your work, Git creates a unique ID (a.k.a. the \"SHA\" or \"hash\") that allows you to keep record of the specific changes committed along with who made them and when. Commits usually contain a commit message which is a brief description of what changes were made."));
        vocabList.add(new Vocab("commit message", "Short, descriptive text that accompanies a commit and communicates the change the commit is introducing"));
        vocabList.add(new Vocab("contributor", "    A(n) ___ is someone who does not have collaborator access to a repository but has contributed to a project and had a pull request they opened merged into the repository."));
        vocabList.add(new Vocab("default branch", " The base branch for new pull requests and code commits in a repository. Each repository has at least one branch, which Git creates when you initialize the repository. The first branch is usually called main, and is often the default branch."));
        vocabList.add(new Vocab("diff", "   A(n) ___ is the difference in changes between two commits, or saved changes. The diff will visually describe what was added or removed from a file since its last commit."));
        vocabList.add(new Vocab("feature branch", " A branch used to experiment with a new feature or fix an issue that is not in production. Also called a topic branch."));
        vocabList.add(new Vocab("fetch", "  When you use git fetch, you're adding changes from the remote repository to your local working branch without committing them. Unlike git pull, fetching allows you to review changes before committing them to your local branch."));
        vocabList.add(new Vocab("force push", " A Git push that overwrites the remote repository with local changes without regard for conflicts. Or, you know, a Star Wars ability."));
        vocabList.add(new Vocab("fork", "   A(n) ___ is a personal copy of another user's repository that lives on your account. Forks allow you to freely make changes to a project without affecting the original upstream repository. You can also open a pull request in the upstream repository and keep your fork synced with the latest changes since both repositories are still connected."));
        vocabList.add(new Vocab("issue", "  A(n) ___ are suggested improvements, tasks or questions related to the repository. Issues can be created by anyone (for public repositories), and are moderated by repository collaborators. Each issue contains its own discussion thread. You can also categorize an issue with labels and assign it to someone."));
        vocabList.add(new Vocab("main", "   The default development branch. Whenever you create a Git repository, a branch named is created, and becomes the active branch. In most cases, this contains the local development, though that is purely by convention and is not required."));
        vocabList.add(new Vocab("merge", "  Merging takes the changes from one branch (in the same repository or from a fork), and applies them into another. This often happens as a \"pull request\" (which can be thought of as a request to merge), or via the command line. A merge can be done through a pull request via the GitHub.com web interface if there are no conflicting changes, or can always be done via the command line."));
        vocabList.add(new Vocab("merge conflict", " A difference that occurs between merged branches. A(n) ___ happen when people make different changes to the same line of the same file, or when one person edits a file and another person deletes the same file. The merge conflict must be resolved before you can merge the branches"));
        vocabList.add(new Vocab("organization", "   A(n) ___ is a group of two or more users that typically mirror real-world organizations. They are administered by users and can contain both repositories and teams."));
        vocabList.add(new Vocab("private repository", " ___ are only visible to the repository owner and collaborators that the owner specified."));
        vocabList.add(new Vocab("private repositories", "   ___ are only visible to the repository owner and collaborators that the owner specified."));
        vocabList.add(new Vocab("public repository", "  A ___ can be viewed by anyone, including people who aren't GitHub users. I mean...did we expect anything else?"));
        vocabList.add(new Vocab("pull", "   ___ refers to when you are fetching in changes and merging them. For instance, if someone has edited the remote file you're both working on, you'll want to pull in those changes to your local copy so that it's up to date. See also fetch."));
        vocabList.add(new Vocab("pull requests", "  ___ are proposed changes to a repository submitted by a user and accepted or rejected by a repository's collaborators. Like issues, pull requests each have their own discussion forum."));
        vocabList.add(new Vocab("push", "   To ___ means to send your committed changes to a remote repository on GitHub.com. For instance, if you change something locally, you can push those changes so that others may access them."));
        vocabList.add(new Vocab("repository", " A(n) ___ is the most basic element of GitHub. They're easiest to imagine as a project's folder. A repository contains all of the project files (including documentation), and stores each file's revision history. Repositories can have multiple collaborators and can be either public or private."));
        vocabList.add(new Vocab("upstream", "   When talking about a branch or a fork, the primary branch on the original repository is often referred to as the ___, since that is the main place that other changes will come in from. The branch/fork you are working on is then called the \"downstream\". Also called origin."));

        return vocabList;
    }


}

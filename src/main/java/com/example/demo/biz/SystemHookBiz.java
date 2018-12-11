package com.example.demo.biz;

import com.example.demo.entity.HookRequestBody;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.PullCommand;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.internal.storage.file.FileRepository;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.transport.UsernamePasswordCredentialsProvider;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.File;

@Component
public class SystemHookBiz {
    @Value("${git.local.path}")
    private String gitPath;

    @Value("${git.remote.src}")
    private String srcHost;

    @Value("${git.remote.dst}")
    private String dstHost;


    public void handleEvent(HookRequestBody hookInfo) {
        String http_url = hookInfo.getProject().getHttp_url();
        String ref = hookInfo.getRef();
        String path_with_namespace = hookInfo.getProject().getPath_with_namespace();
        String name = hookInfo.getProject().getName();
        String event_name = hookInfo.getEvent_name();

        if ("push".equals(event_name)){
            if (http_url.equals("http://192.168.102.111/testGroup/spring-test.git")){
                System.out.println("ignore dst hook request....");
                return;
            }
            pullOringinAndPushBackup(hookInfo);
        }else {
            System.out.println("other event handler is coming soon....");
        }
    }

    //从gitlab拉取代码，并push到备份gitlab
    private void pullOringinAndPushBackup(HookRequestBody hookInfo) {

        //gitPull(new File(gitPath+File.separator+path_with_namespace.replaceAll("/", "-")));
        gitPull(new File("d:\\lijiyang"));

        String remoteURL = "http://192.168.102.111/testGroup/spring-test.git";
        //gitPush(new File(gitPath+File.separator+path_with_namespace.replaceAll("/", "-")), remoteURL);
        gitPush(new File("d:\\lijiyang"), remoteURL);
    }


    public void gitClone(String path, String name) throws GitAPIException {
        File file = new File(gitPath + File.separator + path.replace("/", "-"));
        //Git.cloneRepository().setURI("git@192.168.102.111:test/spring-test.git").setGitDir(file).setCloneAllBranches(true).call();
        Git.cloneRepository().setURI("http://192.168.102.111/test/spring-test.git")
                .setGitDir(file)
                .setCloneAllBranches(true)
                .setCredentialsProvider( new UsernamePasswordCredentialsProvider( "root", "root1234"))
                .call();
    }

    public void gitClone(String remoteUrl, File repoDir) {
        try {
            Git git = Git.cloneRepository()
                    .setURI(remoteUrl)
                    .setDirectory(repoDir)
                    .setCredentialsProvider( new UsernamePasswordCredentialsProvider( "root", "root1234"))
                    .call();

            System.out.println("Cloning from " + remoteUrl + " to " + git.getRepository());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void gitPull(File repoDir){
        File RepoGitDir = new File(repoDir.getAbsolutePath() + File.separator + ".git");
        if (!RepoGitDir.exists()) {
            System.out.println("Error! Not Exists : " + RepoGitDir.getAbsolutePath());
        } else {
            Repository repo = null;
            try {
                repo = new FileRepository(RepoGitDir.getAbsolutePath());
                Git git = new Git(repo);
                PullCommand pullCmd = git.pull();
                pullCmd.setCredentialsProvider(new UsernamePasswordCredentialsProvider("root","root1234"));
                pullCmd.call();

                System.out.println("Pulled from remote repository to local repository at " + repo.getDirectory());
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (repo != null) {
                    repo.close();
                }
            }
        }
    }


    public void gitPush(File repoDir, String remoteUrl){
        File RepoGitDir = new File(repoDir.getAbsolutePath() + File.separator + ".git");
        Git git = null;
        try {
            git = Git.open(RepoGitDir);

            git.push().setCredentialsProvider(new UsernamePasswordCredentialsProvider("root", "root1234")).setRemote(remoteUrl).call();

            System.out.println("提交成功");
        } catch (Exception e){
            e.printStackTrace();
            System.out.println("提交失败");
        } finally{
            if (git != null) {
                git.close();
            }
        }
    }

}

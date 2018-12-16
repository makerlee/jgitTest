package com.example.demo.biz;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.entity.HookRequestBody;
import com.example.demo.utils.HttpClientUtil;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.PullCommand;
import org.eclipse.jgit.api.PullResult;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.internal.storage.file.FileRepository;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.transport.PushResult;
import org.eclipse.jgit.transport.RefSpec;
import org.eclipse.jgit.transport.UsernamePasswordCredentialsProvider;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Iterator;

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
        String ref = hookInfo.getRef();//分支
        int project_id = hookInfo.getProject().getId();
        String subDir = project_id + File.separator + ref.substring(ref.lastIndexOf("/")+1);

        //gitPull(new File(gitPath+File.separator+path_with_namespace.replaceAll("/", "-")));
        gitPull(new File(gitPath + File.separator + subDir), ref);

        String remoteURL = "http://192.168.102.111/testGroup/spring-test.git";
        //gitPush(new File(gitPath+File.separator+path_with_namespace.replaceAll("/", "-")), remoteURL);
        gitPush(new File(gitPath + File.separator + subDir), remoteURL, ref);
    }


    public void gitClone(String remoteUrl, File repoDir, String ref) {
        Git git = null;
        try {
            git = Git.cloneRepository()
                    .setURI(remoteUrl)
                    .setBranch(ref)
                    .setDirectory(repoDir)
                    .setCredentialsProvider( new UsernamePasswordCredentialsProvider( "root", "root1234"))
                    .call();

            System.out.println("Cloning from " + remoteUrl + " to " + git.getRepository());
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(null!=git){
                git.close();
            }
        }
    }

    public void gitPull(File repoDir, String ref){
        File RepoGitDir = new File(repoDir.getAbsolutePath() + File.separator + ".git");
        if (!RepoGitDir.exists()) {
            System.out.println("Error! Not Exists : " + RepoGitDir.getAbsolutePath());
        } else {
            Repository repo = null;
            Git git = null;
            try {
                repo = new FileRepository(RepoGitDir.getAbsolutePath());
                git = new Git(repo);
                PullCommand pullCmd = git.pull();
                pullCmd.setRemoteBranchName(ref);
                pullCmd.setCredentialsProvider(new UsernamePasswordCredentialsProvider("root","root1234"));
                PullResult call = pullCmd.call();

                System.out.println(call);

                System.out.println("Pulled from remote repository to local repository at " + repo.getDirectory());
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (repo != null) {
                    repo.close();
                }
                if (git != null){
                    git.close();
                }
            }
        }
    }


    public void gitPush(File repoDir, String remoteUrl, String ref){
        File RepoGitDir = new File(repoDir.getAbsolutePath() + File.separator + ".git");
        Git git = null;
        try {
            git = Git.open(RepoGitDir);
            Iterable<PushResult> call = git.push()
                    .setCredentialsProvider(new UsernamePasswordCredentialsProvider("root", "root1234"))
                    .setRemote(remoteUrl)
                    .setRefSpecs(new RefSpec(ref + ":" + ref.substring(ref.lastIndexOf("/") +1 )))
                    .call();

//            Iterator<PushResult> iterator = call.iterator();
//            while (iterator.hasNext()){
//                PushResult next = iterator.next();
//                System.out.println(next.getMessages());
//            }
            System.out.println("push to '" + remoteUrl +"' success");
        } catch (Exception e){
            e.printStackTrace();
            System.out.println("提交失败");
        } finally{
            if (git != null) {
                git.close();
            }
        }
    }

    /**
     * POST /projects/:id/repository/branches
     * 
     * @param project_id
     * @param branch
     */
    public void createBranch(Integer project_id, String branch, String ref) throws Exception {
        String url = dstHost + String.format("/projects/%d/repository/branches?private_token=%s&branchName=%s&ref=%s", project_id,"123", branch, ref);
        String s = HttpClientUtil.doPost(new URI(url), null);
    }

}

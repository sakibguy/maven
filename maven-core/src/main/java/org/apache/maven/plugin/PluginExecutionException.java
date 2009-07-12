package org.apache.maven.plugin;

import org.apache.maven.project.DuplicateArtifactAttachmentException;
import org.apache.maven.project.MavenProject;

public class PluginExecutionException
    extends PluginManagerException
{

    private final MojoExecution mojoExecution;

    public PluginExecutionException( MojoExecution mojoExecution, MavenProject project, String message )
    {
        super( mojoExecution.getMojoDescriptor(), project, message );
        this.mojoExecution = mojoExecution;
    }

    public PluginExecutionException( MojoExecution mojoExecution, MavenProject project, Exception cause )
    {
        super( mojoExecution.getMojoDescriptor(), project, constructMessage( cause ), cause );
        this.mojoExecution = mojoExecution;
    }

    public PluginExecutionException( MojoExecution mojoExecution, MavenProject project, DuplicateArtifactAttachmentException cause )
    {
        super( mojoExecution.getMojoDescriptor(), project, constructMessage( cause ), cause );
        this.mojoExecution = mojoExecution;
    }

    public MojoExecution getMojoExecution()
    {
        return mojoExecution;
    }

    private static String constructMessage( Throwable cause )
    {
        if ( cause != null )
        {
            return "Mojo execution failed: " + cause.getMessage();
        }
        else
        {
            return "Mojo execution failed.";
        }
    }

}
pipeline
{
    agent any

    stages 
    {
        stage('Build')
        {
            steps
            {
                echo 'Build Application'
            }
        }
        stage('Test')
        {
            steps
            {
                echo 'Test Application'
            }
        }
        stage('Deploy')
        {
            steps
            {
                echo 'Deploy Application'
            }
        }
    }
    post
    {
        always{
            emailext body: 'Summery', subject: 'PipeLine Status', to: 'harishanker.yadav0891@gmail.com'
        }
    }
}

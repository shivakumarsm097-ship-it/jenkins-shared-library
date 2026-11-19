// vars/buildApp.groovy
// A global step. Jenkinsfiles call it as: buildApp goal: 'clean install'
def call(Map config = [:]) {
    def goal = config.goal ?: 'clean install'
    echo "buildApp: running mvn ${goal}"
    sh "mvn ${goal}"
}

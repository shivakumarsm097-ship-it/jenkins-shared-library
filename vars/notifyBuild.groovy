// vars/notifyBuild.groovy
// Uses the Utils class (src/) and the template file (resources/).
def call(Map config = [:]) {
    def status = config.status ?: 'SUCCESS'
    def team = config.team ?: 'dev-team'

    def utils = new org.shiva.Utils(this)
    utils.banner('Build report')

    def template = libraryResource 'templates/notify.txt'
    def message = template
        .replace('{{TEAM}}', team)
        .replace('{{JOB}}', env.JOB_NAME)
        .replace('{{BUILD}}', env.BUILD_NUMBER)
        .replace('{{STATUS}}', status)
        .replace('{{TIME}}', utils.now())
    echo message
}

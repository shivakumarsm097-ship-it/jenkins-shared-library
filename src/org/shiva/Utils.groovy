package org.shiva

// A helper class. It must be Serializable.
// It cannot call pipeline steps directly, so the pipeline passes 'this' into it.
class Utils implements Serializable {
    def steps

    Utils(steps) {
        this.steps = steps
    }

    String now() {
        return new Date().format('dd-MM-yyyy HH:mm:ss')
    }

    void banner(String text) {
        steps.echo "==== ${text} ===="
    }
}

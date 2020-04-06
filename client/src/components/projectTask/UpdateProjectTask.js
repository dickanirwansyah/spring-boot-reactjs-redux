import React, {Component} from "react";

class UpdateProjectTask extends Component {
    render(){
        return (
            <div className="updateProjectTask">
            <div className="container">
                <div className="row">
                    <div className="col-md-8 m-auto">
                        <a href="/ProjectBoard.html" className="btn btn-light">
                            Back to Board
                        </a>
                        <h4 className="display-4 text-center">Add /Update Project Task</h4>
                        <form>
                            <div className="form-group">
                                <input type="text" class="form-control form-control-lg" name="summary" placeholder="Project Task summary" />
                            </div>
                            <div className="form-group">
                                <textarea class="form-control form-control-lg" placeholder="Acceptance Criteria" name="acceptanceCriteria"></textarea>
                            </div>
                            <div className="form-group">
                                <select className="form-control form-control-lg" name="status">
                                    <option value="">Select Status</option>
                                    <option value="TO_DO">TO DO</option>
                                    <option value="IN_PROGRESS">IN PROGRESS</option>
                                    <option value="DONE">DONE</option>
                                </select>
                            </div>
                            <input type="submit" class="btn btn-primary btn-block mt-4" />
                        </form>
                    </div>
                </div>
            </div>
        </div>
        )
    }
}

export default UpdateProjectTask;
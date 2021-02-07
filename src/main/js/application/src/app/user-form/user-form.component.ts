import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { PeopleService } from '../service/people.service';
import { People } from '../model/people';

@Component({
  selector: 'app-user-form',
  templateUrl: './user-form.component.html',
  styleUrls: ['./user-form.component.css']
})
export class UserFormComponent {

  people: People;

  constructor(private route: ActivatedRoute, private router: Router, private userService: PeopleService) {
    this.people = new People();
  }

  onSubmit() {
    this.userService.save(this.people).subscribe(result => this.gotoUserList());
  }

  gotoUserList() {
    this.router.navigate(['/users']);
  }
}

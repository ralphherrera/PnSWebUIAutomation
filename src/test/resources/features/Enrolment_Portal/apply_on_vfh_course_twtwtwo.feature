# new feature
# Tags: optional
@web
Feature: Apply on VFH Course
  As a learner on TAFE
  I should be able to apply on a VFH Course via Enrolment Portal\
  So that I can keep improving myself

#  @ApplyLearnerOnVFHCourse
  Scenario: Apply Learner on a VFH Course via Enrolment Portal
    Given I navigate to the TAFE Enrolment Site
    And I fill out the details in the Get Started Page questions
    And I enter my personal information in about you page one of three
    And I enter my personal information in about you page two of three
    And I proceed with the USI Unsuccessful verification
    And I check and confirm the details I entered previously
    And I enter my personal information in about you page three of three
    And I fill out the Qualifications Page questions
    When I confirm all the details I entered and proceed
    Then I should see the confirmation for my application for the course